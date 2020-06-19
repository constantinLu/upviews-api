package com.program.upviews.service;

import com.program.upviews.common.Role;
import com.program.upviews.configuration.ForgotPasswordTokenConfiguration;
import com.program.upviews.configuration.PasswordConfiguration;
import com.program.upviews.dto.AccountDto;
import com.program.upviews.dto.RoleDto;
import com.program.upviews.dto.UserDto;
import com.program.upviews.entity.AccountEntity;
import com.program.upviews.entity.RoleEntity;
import com.program.upviews.entity.UserEntity;
import com.program.upviews.exceptions.custom.*;
import com.program.upviews.repository.AccountRepository;
import com.program.upviews.repository.RoleRepository;
import com.program.upviews.repository.UserRepository;
import com.program.upviews.requests.ChangePasswordRequest;
import com.program.upviews.requests.RegisterRequest;
import com.program.upviews.requests.ResetPasswordRequest;
import com.program.upviews.util.DateUtil;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final AccountRepository accountRepository;

    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;

    private final PasswordConfiguration passwordConfiguration;

    private final ForgotPasswordTokenConfiguration forgotPasswordTokenConfiguration;

    private final EmailService emailService;

    private final String EMAIL_PATTERN = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public UserService(UserRepository userRepository, AccountRepository accountRepository, RoleRepository roleRepository,
                       ModelMapper modelMapper, PasswordConfiguration passwordConfiguration,
                       ForgotPasswordTokenConfiguration forgotPasswordTokenConfiguration, EmailService emailService) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.passwordConfiguration = passwordConfiguration;
        this.forgotPasswordTokenConfiguration = forgotPasswordTokenConfiguration;
        this.emailService = emailService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> userOptional = userRepository.findByUserName(username);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(username);
        }
        List<GrantedAuthority> roles = new ArrayList<>();

        UserDto userDto = modelMapper.map(userOptional.get(), UserDto.class);
        RoleDto roleDto = modelMapper.map(userOptional.get().getRole(), RoleDto.class);
        roles.add(new SimpleGrantedAuthority(roleDto.getRole().toString()));
        return new User(userDto.getUserName(), userDto.getPassword(), roles);


    }


    public List<UserDto> getAllUsers() {
        return ((List<UserEntity>) userRepository.findAll()).stream()
                .map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    private void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public void changePassword(String username, ChangePasswordRequest request) {

        Optional<UserEntity> userOptional = userRepository.findByUserName(username);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(username);
        }

        if (!passwordConfiguration.verifyHash(request.getPassword(), userOptional.get().getPassword())) {
            throw new InvalidPasswordException(username);
        }

        if (!request.getPassword().equals(request.getNewPassword()) &&
                request.getNewPassword().equals(request.getReTypeNewPassword())) {

            UserDto userDto = UserDto.builder()
                    .userName(username)
                    .password(request.getNewPassword())
                    .build();

            updatePassword(userDto);

        } else {
            throw new PasswordMisMatchException(String.format
                    ("New Password: %s, RetypedPassword %s", request.getNewPassword(), request.getReTypeNewPassword()));
        }
    }

    public void forgotPassword(String email) {

        String finalEmail = extractEmailAddress(email);
        Optional<AccountEntity> userInfoOptional = accountRepository.findByEmail(finalEmail);
        Optional<UserEntity> userEntity = userRepository.findUserEntityByAccountEmail(userInfoOptional.get().getEmail());

        if (userEntity.isPresent()) {
            userEntity.get().setResetToken(createUserResetToken());
            userEntity.get().setTokenExpiration(Timestamp.valueOf((LocalDateTime.now()).plusMinutes(forgotPasswordTokenConfiguration.getTokenExpirationTime())));
            save(userEntity.get());
            String token = userEntity.get().getResetToken();
            SimpleMailMessage mailMessage = getSimpleMailMessage(userEntity.get(), token);
            emailService.sendEmail(mailMessage);
        } else {
            throw new InvalidEmailException(String.format("Email %s", finalEmail));
        }
    }

    private String createUserResetToken() {
        boolean tokenExists = true;
        String token = UUID.randomUUID().toString();
        while (tokenExists) {
            Optional<UserEntity> userEntity = userRepository.findByResetToken(token);
            if (userEntity.isEmpty()) {
                tokenExists = false;
            } else {
                token = UUID.randomUUID().toString();
            }
        }
        return token;
    }

    private String extractEmailAddress(String email) {
        return email.replace("{\"email\":{\"email\":\"", "").replace("\"}}", "");
    }

    private SimpleMailMessage getSimpleMailMessage(UserEntity userEntity, String token) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userEntity.getAccount().getEmail());
        mailMessage.setSubject("Complete Password Reset!");
        mailMessage.setFrom("secur.app.20@gmail.com");
        mailMessage.setText(createEmailBody(token));
        return mailMessage;
    }

    private String createEmailBody(String token) {
        StringBuilder emailBody = new StringBuilder();
        //TODO: Get frontend URL from eureka
        emailBody.append("To reset your password, click the link below:\n")
                .append("http://localhost:3000/")
                .append("resetPassword?token=")
                .append(token)
                .append("\n")
                .append("This link will be valid only for ")
                .append(forgotPasswordTokenConfiguration.getTokenExpirationTime())
                .append(" minutes. Make sure you reset your password before that.");
        return emailBody.toString();
    }

    public void resetUserPassword(String token, ResetPasswordRequest request) {

        Optional<UserEntity> userEntity = userRepository.findByResetToken(token);

        if (userEntity.isPresent()) {
            if (DateUtil.isDateInThePast(userEntity.get().getTokenExpiration())) {
                throw new RuntimeException("Reset password token is expired");
            }
            if (request.getNewPassword().equals(request.getReTypeNewPassword())) {
                userEntity.get().setResetToken(null);
                userEntity.get().setPassword(passwordConfiguration.hash(request.getNewPassword()));
                save(userEntity.get());
                UserDto userDto = modelMapper.map(userEntity, UserDto.class);
                resetPassword(userDto);
            } else {
                throw new PasswordMisMatchException(String.format
                        ("New Password: %s, RetypedPassword %s", request.getNewPassword(), request.getReTypeNewPassword()));
            }
        } else {
            throw new RuntimeException("Given token does not exist");
        }
    }

    public Boolean isResetPasswordTokenExpired(String token) {
        Optional<UserEntity> userEntity = userRepository.findByResetToken(token);
        if (userEntity != null) {
            Timestamp tokenExpirationTime = userEntity.get().getTokenExpiration();
            return DateUtil.isDateInThePast(tokenExpirationTime);
        } else {
            throw new RuntimeException("Given token does not exist");
        }
    }

    private void updatePassword(UserDto userDto) {
        userRepository.updatePassword(passwordConfiguration.hash(userDto.getPassword()), userDto.getUserName());
    }

    private void resetPassword(UserDto userDto) {
        userRepository.resetPassword(passwordConfiguration.hash(userDto.getPassword()), userDto.getResetToken());
    }

    public void registerUser(RegisterRequest request) {

        Matcher matcher = pattern.matcher(request.getEmail());

        if (!matcher.matches()) {
            throw new InvalidEmailException(String.format("Email %s", request.getEmail()));
        }

        Optional<UserEntity> user = userRepository.findByUserName(request.getUsername());

        if (user.isPresent()) {
            throw new UsernameAlreadyExistsException(String.format("UserName %s", request.getUsername()));
        }

        Optional<AccountEntity> userAccount = accountRepository.findByEmail(request.getEmail());

        if (userAccount.isPresent()) {
            throw new EmailAlreadyExistsException(String.format("Email: %s", request.getEmail()));
        }

        UserDto userDto = UserDto.builder()
                .userName(request.getUsername())
                .password(passwordConfiguration.getEncoder().encode(request.getPassword()))
                .build();

        AccountDto userInfoDto = AccountDto.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        RoleEntity roleEntity = roleRepository.findByRole(Role.USER);

        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userEntity.setAccount(modelMapper.map(userInfoDto, AccountEntity.class));
        userEntity.setRole(roleEntity);

        userRepository.save(userEntity);
    }
}
