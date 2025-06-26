package com.wevi.domain.member.service;

import com.wevi.common.jwt.JwtTokenProvider;
import com.wevi.common.redis.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
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
