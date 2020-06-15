package com.program.upviews.configuration;

import com.google.common.net.HttpHeaders;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "application.jwt")
public class JwtConfiguration {

    private String secretKey;

    private String tokenPrefix;

    private Integer tokenExpirationDays;

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }

    @Bean
    public SecretKey secretKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

}
