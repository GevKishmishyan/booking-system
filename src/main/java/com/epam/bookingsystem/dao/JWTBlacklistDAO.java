package com.epam.bookingsystem.dao;


import com.epam.bookingsystem.exception.JWTIsInBlacklistException;
import com.epam.bookingsystem.security.CurrentUser;
import com.epam.bookingsystem.security.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class JWTBlacklistDAO {

    final
    JwtUtils jwtUtils;

    private final RedisTemplate<String, String> template;

    public JWTBlacklistDAO(RedisTemplate<String, String> template, JwtUtils jwtUtils) {
        this.template = template;
        this.jwtUtils = jwtUtils;
    }

    public void addJWTInBlacklist(String jwt) {

        template.setHashValueSerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());

        Date expirationDate = jwtUtils.extractExpiration(jwt);
        Date currentDate = new Date();
        long timeToLiveInMilliseconds = expirationDate.getTime() - currentDate.getTime();

        template.opsForValue().set(jwt, "ok", timeToLiveInMilliseconds, TimeUnit.MILLISECONDS);
        log.info("jwt " + jwt + " of the user with userName " + getUserDetails().getUsername() + " added to blacklist with TTL in ms = " + timeToLiveInMilliseconds);
    }

    public boolean existsInBlacklist(String jwt) {
        if (template.hasKey(jwt)) {
            log.error("jwt " + jwt + " is in blacklist");
            throw new JWTIsInBlacklistException("you are logged out , please log in again");
        }
        return false;
    }

    public static CurrentUser getUserDetails() {
        try {
            return (CurrentUser) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();
        } catch (Exception ignored) {
            throw new RuntimeException("Access denied");
        }
    }
}
