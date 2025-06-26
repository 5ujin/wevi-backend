package com.wevi.domain.member.controller;

import com.wevi.domain.member.dto.LoginReq;
import com.wevi.domain.member.dto.LoginRes;
import com.wevi.domain.member.dto.SignupReq;
import com.wevi.domain.member.dto.SignupRes;
import com.wevi.domain.member.service.LoginService;
import com.wevi.domain.member.service.SignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final SignupService signupService;
    private final LoginService loginService;

    /**
     * 회원가입 API
     * POST /api/members/signup
     */
    @PostMapping("/signup")
    public ResponseEntity<SignupRes> signup(@RequestBody @Valid SignupReq signupReq) {
        SignupRes signupRes = signupService.signup(signupReq);
        return ResponseEntity.ok(signupRes);
    }

    /**
     * 로그인 API
     * POST /api/members/login
     */
    @PostMapping("/login")
    public ResponseEntity<LoginRes> login(@RequestBody @Valid LoginReq loginReq) {
        LoginRes loginRes = loginService.login(loginReq);
        return ResponseEntity.ok(loginRes);
    }
}
