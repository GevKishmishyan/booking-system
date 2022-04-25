package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.security.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

@Component
public class JWTBlacklistDAO {

    final
    JwtUtils jwtUtils;

    private final RedisTemplate< String, String> template;

    public JWTBlacklistDAO(RedisTemplate<String, String> template, JwtUtils jwtUtils) {
        this.template = template;
        this.jwtUtils = jwtUtils;
    }

    public void addJWTInBlacklist(String jwt) {
        System.out.println("addJWTInBlacklist() ");

        template.setHashValueSerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());

        Date expirationDate = jwtUtils.extractExpiration(jwt);
        System.out.println("expirationDate geted from jwtUtils = " + expirationDate);
        Date currentDate = new Date();

        long timeToLiveInMilliseconds = expirationDate.getTime() - currentDate.getTime();
        System.out.println("timeToLiveInMilliseconds " + timeToLiveInMilliseconds);

        template.opsForValue().set(jwt, "ok",timeToLiveInMilliseconds, TimeUnit.MILLISECONDS);
    }

    public boolean existsInBlacklist(String jwt) {
        return template.hasKey(jwt);
    }

}
