package com.epam.bookingsystem.security.util;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@Component
public class JwtUtils {

    private String secret;
    private int jwtAccessExpirationMs;
    private int jwtRefreshExpirationMs;

    @Value("${jwt.secret}")
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Value("${jwt.accessExpirationMs}")
    public void setJwtAccessExpirationMs(int jwtAccessExpirationMs) {
        this.jwtAccessExpirationMs = jwtAccessExpirationMs;
    }

    @Value("${jwt.refreshExpirationMs}")
    public void setJwtRefreshExpirationInMs(int jwtRefreshExpirationMs) {
        this.jwtRefreshExpirationMs = jwtRefreshExpirationMs;
    }

    public String generateJwtToken(UserDetails userDetails, boolean forRefresh) {
        Map<String, Object> claims = new HashMap<>();

        final Date createdDate = new Date();
        final Date expirationDate = calculateExpirationDate(createdDate, forRefresh);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private Date calculateExpirationDate(Date createdDate, boolean forRefresh) {

        int jwtExpirationInMs;
        if (forRefresh) {
            jwtExpirationInMs = jwtRefreshExpirationMs;
        } else {
            jwtExpirationInMs = jwtAccessExpirationMs;
        }
        return new Date(createdDate.getTime() + jwtExpirationInMs);
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: ", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: ", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: ", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: ", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: ", e.getMessage());
        }
        return false;

    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

}
