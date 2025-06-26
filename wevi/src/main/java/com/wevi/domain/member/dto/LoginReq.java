package com.wevi.domain.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record LoginReq(
        @NotBlank(message = "이메일은 필수입니다.")
        @Email(message = "이메일 형식이 유효하지 않습니다.")
        String email,  // ← 이메일을 loginId로 사용

        @NotBlank(message = "비밀번호는 필수입니다.")
        @Pattern(
                regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=\\-{}\\[\\]|\\\\:;\"'<>,.?/~`])[A-Za-z\\d!@#$%^&*()_+=\\-{}\\[\\]|\\\\:;\"'<>,.?/~`]{8,}$",
                message = "비밀번호는 영문자, 숫자, 특수문자를 포함한 8자 이상이어야 합니다."
        )
        String password
) {}
