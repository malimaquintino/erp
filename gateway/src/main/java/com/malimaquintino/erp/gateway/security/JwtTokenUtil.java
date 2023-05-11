package com.malimaquintino.erp.gateway.security;

import com.malimaquintino.erp.gateway.configuration.JwtConfiguration;
import com.malimaquintino.erp.gateway.exception.JwtTokenIncorrectStructureException;
import com.malimaquintino.erp.gateway.exception.JwtTokenMalFormedException;
import com.malimaquintino.erp.gateway.exception.JwtTokenMissingException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Log4j2
@Component
@RequiredArgsConstructor
public class JwtTokenUtil {

    private final JwtConfiguration jwtConfiguration;

    public String generateToken(String id) {
        Claims claims = Jwts.claims().setSubject(id);
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + jwtConfiguration.getValidity() * 1000 * 60;
        Date expiration = new Date(expMillis);
        SecretKey secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtConfiguration.getSecret()));
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowMillis)).setExpiration(expiration)
                .signWith(secret).compact();
    }

    public void validateToken(final String header) {
        try {
            String[] parts = header.split(" ");
            if (parts.length != 2 || !"Bearer".equals(parts[0])) {
                throw new JwtTokenIncorrectStructureException("Incorrect Authentication Structure");
            }
        } catch (SignatureException ex) {
            log.warn(ex.getMessage());
            throw new JwtTokenMalFormedException("Invalid Jwt signature");
        } catch (MalformedJwtException ex) {
            log.warn(ex.getMessage());
            throw new JwtTokenMalFormedException("Invalid Jwt token");
        } catch (ExpiredJwtException ex) {
            log.warn(ex.getMessage());
            throw new JwtTokenMalFormedException("Expired Jwt token");
        } catch (UnsupportedJwtException ex) {
            log.warn(ex.getMessage());
            throw new JwtTokenMalFormedException("Unsupported Jwt token");
        } catch (IllegalArgumentException ex) {
            log.warn(ex.getMessage());
            throw new JwtTokenMissingException("Jwt claims string is empty");
        }
    }
}
