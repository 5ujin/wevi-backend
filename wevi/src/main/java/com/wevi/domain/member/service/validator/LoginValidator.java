package com.wevi.domain.member.service.validator;

import com.wevi.common.exception.BusinessException;
import com.wevi.common.exception.ErrorCode;
import com.wevi.domain.member.dto.LoginReq;
import com.wevi.domain.member.entity.Member;
import com.wevi.domain.member.respository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginValidator {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member validate(LoginReq req) {
        Member member = memberRepository.findByEmail(req.email())
                .orElseThrow(() -> new BusinessException(ErrorCode.INVALID_LOGIN_INFO));

        if (!passwordEncoder.matches(req.password(), member.getPassword())) {
            throw new BusinessException(ErrorCode.INVALID_LOGIN_INFO);
        }

        return member;
    }
}