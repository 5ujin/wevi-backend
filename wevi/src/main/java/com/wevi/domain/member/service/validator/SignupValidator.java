package com.wevi.domain.member.service.validator;

import com.wevi.common.exception.ErrorCode;
import com.wevi.domain.member.exception.SignupException;
import com.wevi.domain.member.respository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignupValidator {

    private final MemberRepository memberRepository;

    /**
     * 이메일이 이미 존재하는지 검사
     * @throws com.wevi.domain.member.exception.SignupException 중복일 경우
     */
    public void validateDuplicateEmail(String email) {
        if (memberRepository.existsByEmail(email)) {
            throw new SignupException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }
    }
}
