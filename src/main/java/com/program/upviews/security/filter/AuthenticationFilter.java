package com.program.upviews.security.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import static com.program.upviews.common.Commons.ROLES;
import com.program.upviews.configuration.JwtConfiguration;
import com.program.upviews.exceptions.custom.AuthException;
import com.program.upviews.exceptions.custom.InputStreamException;
import com.program.upviews.requests.AuthenticationRequest;
import static com.program.upviews.util.Api.LOGIN_URL;
import com.program.upviews.util.DateUtil;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    private final JwtConfiguration jwtConfiguration;

    public AuthenticationFilter(AuthenticationManager authenticationManager, JwtConfiguration jwtConfiguration) {
        this.authenticationManager = authenticationManager;
        this.jwtConfiguration = jwtConfiguration;
        setFilterProcessesUrl(LOGIN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {

            AuthenticationRequest authenticationRequest = new ObjectMapper().readValue(request.getInputStream(), AuthenticationRequest.class);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            );
            return authenticationManager.authenticate(authentication);

        } catch (AuthenticationException e) {
            logger.info("Authentication not possible with the current credentials.");
            throw new AuthException(e.getMessage());
        } catch (IOException e) {
            logger.info("Request from input stream not valid.");
            throw new InputStreamException(e.getMessage());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain
            chain, Authentication authResult) {

        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim(ROLES, authResult.getAuthorities())
                //.setExpiration(Date.valueOf(LocalDate.now().plusDays(jwtConfiguration.getTokenExpirationDays())))
                //TODO: TESTING PURPOSES. DELETE AFTER
                .setExpiration(DateUtil.asDate((LocalDateTime.now()).plusMinutes(jwtConfiguration.getTokenExpirationDays())))
                .signWith(jwtConfiguration.secretKey())
                .compact();

        response.addHeader(jwtConfiguration.getAuthorizationHeader(), jwtConfiguration.getTokenPrefix() + token);
    }
}