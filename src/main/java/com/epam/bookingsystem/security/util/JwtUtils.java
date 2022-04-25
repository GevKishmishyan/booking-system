package com.epam.bookingsystem.security.util;

import com.epam.bookingsystem.security.CurrentUser;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

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

    public String generateJwtToken(UserDetails userDetailsImpl, boolean forRefresh) {
        Map<String, Object> claims = new HashMap<>();

        final Date createdDate = new Date();
        final Date expirationDate = calculateExpirationDate(createdDate, forRefresh);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetailsImpl.getUsername())
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
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            System.out.println(e);
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
