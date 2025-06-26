package com.wevi.domain.member.service;

import com.wevi.domain.member.dto.LoginReq;
import com.wevi.domain.member.dto.LoginRes;
import com.wevi.domain.member.entity.Member;
import com.wevi.domain.member.service.validator.LoginValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final LoginValidator loginValidator;
    private final TokenManager tokenManager;

    @Override
    public LoginRes login(LoginReq loginReq) {

        // 1. 로그인 정보 유효성 검증
        Member member = loginValidator.validate(loginReq);

        // 2. 토큰 생성
        String accessToken = tokenManager.issueAccessToken(loginReq.email());
        String refreshToken = tokenManager.issueRefreshToken(loginReq.email());

        return new LoginRes(accessToken, refreshToken);
    }
}
