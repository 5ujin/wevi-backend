package com.wevi.domain.member.exception;

import com.wevi.common.exception.BusinessException;
import com.wevi.common.exception.ErrorCode;

public class SignupException extends BusinessException {
    public SignupException(ErrorCode errorCode) {
        super(errorCode);
    }
}
