package com.program.upviews.configuration;

import com.fasterxml.classmate.TypeResolver;
import static com.program.upviews.common.Role.ADMIN;
import com.program.upviews.configuration.swaggerdoc.AuthDocumentation;
import com.program.upviews.security.filter.AuthenticationFilter;
import com.program.upviews.security.filter.CrossOriginFilter;
import com.program.upviews.security.filter.TokenVerifierFilter;
import com.program.upviews.service.UserService;
import static com.program.upviews.util.Api.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import springfox.documentation.spring.web.plugins.DocumentationPluginsManager;
import springfox.documentation.spring.web.scanners.ApiDescriptionReader;
import springfox.documentation.spring.web.scanners.ApiListingScanner;
import springfox.documentation.spring.web.scanners.ApiModelReader;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    private final JwtConfiguration jwtConfiguration;

    private final PasswordConfiguration passwordConfiguration;

    //private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    public SecurityConfiguration(UserService userService, JwtConfiguration jwtConfiguration, PasswordConfiguration passwordConfiguration) {
        this.userService = userService;
        this.jwtConfiguration = jwtConfiguration;
        this.passwordConfiguration = passwordConfiguration;
        //this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                //.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                //.and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(USERS_URL).hasAuthority(ADMIN.name())
                .antMatchers(RESET_PASSWORD_URL, FORGOT_PASSWORD_URL, TOKEN_EXPIRED_URL).permitAll()
                .and()
                .addFilterBefore(new CrossOriginFilter(), AuthenticationFilter.class)
                .addFilter(new AuthenticationFilter(authenticationManager(), jwtConfiguration))
                .addFilterAfter(new TokenVerifierFilter(jwtConfiguration), AuthenticationFilter.class)
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Primary
    @Bean
    public ApiListingScanner addExtraOperations(ApiDescriptionReader apiDescriptionReader, ApiModelReader apiModelReader, DocumentationPluginsManager pluginsManager, TypeResolver typeResolver) {
        return new AuthDocumentation(apiDescriptionReader, apiModelReader, pluginsManager, typeResolver);
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordConfiguration.getEncoder());
        authProvider.setUserDetailsService(userService);
        return authProvider;
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
