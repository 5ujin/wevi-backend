package com.wevi.domain.member.service;

import com.wevi.domain.member.dto.SignupReq;
import com.wevi.domain.member.dto.SignupRes;
import com.wevi.domain.member.entity.Member;
import com.wevi.domain.member.respository.MemberRepository;
import com.wevi.domain.member.service.validator.SignupValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService{

    private final MemberRepository memberRepository;
    private final SignupValidator signupValidator;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignupRes signup(SignupReq req) {

        // 1. 이메일(ID) 중복 검증
        signupValidator.validateDuplicateEmail(req.email());

        // 2. 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(req.password());

        // 3. Member Entity 생성
        Member member = Member.builder()
                .loginId(req.email())
                .email(req.email())
                .password(encodedPassword)
                .name(req.name())
                .birthDay(req.birthDay())
                .cellPhone(req.cellPhone())
                .gender(req.gender())
                .enabledYn("Y")
                .emailValidYn("N")
                .passwordFailCount(0)
                .creator(req.email())
                .updater(req.email())
                .build();

        // 4. 저장
        Member saved = memberRepository.save(member);

        // 5. 결과 반환
        return SignupRes.builder()
                .memberId(saved.getId())
                .message("회원가입 성공")
                .build();
    }
}
