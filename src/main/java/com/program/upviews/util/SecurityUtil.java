package com.program.upviews.util;

import com.google.common.base.Strings;
import static com.program.upviews.common.Commons.AUTHORITY;
import static com.program.upviews.common.Commons.ROLES;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.crypto.SecretKey;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class SecurityUtil {

    private SecurityUtil() {

    }

    public static Authentication getAuthentication(String token, SecretKey secretKey) {
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);

        Claims body = claimsJws.getBody();
        String username = body.getSubject();
        var authorities = (List<Map<Strings, String>>) body.get(ROLES);
        Set<SimpleGrantedAuthority> simpleGrantedAuthority = authorities.stream()
                .map(m -> new SimpleGrantedAuthority(m.get(AUTHORITY)))
                .collect(Collectors.toSet());

        return new PreAuthenticatedAuthenticationToken(username, null, simpleGrantedAuthority);
    }
}
