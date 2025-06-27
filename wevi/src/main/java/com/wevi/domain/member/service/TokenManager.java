package com.wevi.domain.member.service;

import com.wevi.common.jwt.JwtTokenProvider;
import com.wevi.common.redis.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TokenManager {

    private final JwtTokenProvider jwtTokenProvider;
    private final RedisService redisService;

    public String issueAccessToken(String email) {
        return jwtTokenProvider.createAccessToken(email);
    }

    public String issueRefreshToken(String email) {
        String refreshToken = jwtTokenProvider.createRefreshToken(email);
        // redis에 refresh token 저장
        redisService.setRefreshToken(email, refreshToken, jwtTokenProvider.getExpiration(refreshToken));
        return refreshToken;
    }
}
