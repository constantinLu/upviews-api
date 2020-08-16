package com.program.upviews.configuration;

import static com.program.upviews.util.Api.PRODUCTS_URL;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.NullRequestCache;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile("local")
public class SecurityConfigLocal extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/v2/api-docs",
                        "/swagger-ui.html",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/actuator/health",
                        "/login/**",
                        "/desks",
                        "/desk",
                        "/hello-world",
                        "/deskrequests",
                        PRODUCTS_URL,
                        PRODUCTS_URL+"/episodes"
                )
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .requestCache()
                .requestCache(new NullRequestCache())
                .and()
                .csrf()
                .disable();
    }
}
