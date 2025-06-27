package com.wevi.common.redis;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@Slf4j
public class RedisService {


    private final RedisTemplate<String, String> redisTemplate;

    public RedisService(@Qualifier("customRedisTemplate") RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setRefreshToken(String key, String refreshToken, Date expiration) {
        Duration ttl = Duration.between(LocalDateTime.now(), expiration.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        redisTemplate.opsForValue().set("RT:" + key, refreshToken, ttl);
    }

    public String getRefreshToken(String key) {
        return (String) redisTemplate.opsForValue().get("RT:" + key);
    }

    public void deleteRefreshToken(String key) {
        redisTemplate.delete("RT:" + key);
    }
}
