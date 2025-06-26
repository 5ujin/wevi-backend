package com.wevi.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // 400
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "GEN_400_01",  "잘못된 요청입니다."),
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "GEN_400_02",  "요청 값이 유효하지 않습니다."),
    EMAIL_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "SU_400_01", "이미 사용 중인 이메일입니다."),

    // 401
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "TKN_401_01", "토큰이 만료되었습니다."),
    TOKEN_INVALID(HttpStatus.UNAUTHORIZED, "TKN_401_02", "유효하지 않은 토큰입니다."),
    INVALID_LOGIN_INFO(HttpStatus.UNAUTHORIZED, "LGN_401_01", "이메일 또는 비밀번호가 올바르지 않습니다."),

    // 403
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "GEN_403", "접근 권한이 없습니다."),

    // 404
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEM_404", "회원을 찾을 수 없습니다."),

    // 409
    RESOURCE_CONFLICT(HttpStatus.CONFLICT, "GEN_409", "자원이 충돌했습니다."),

    // 500
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "GEN_500", "서버 내부 오류가 발생했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
