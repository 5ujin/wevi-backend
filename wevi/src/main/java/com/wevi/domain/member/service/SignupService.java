package com.wevi.domain.member.service;

import com.wevi.domain.member.dto.SignupReq;
import com.wevi.domain.member.dto.SignupRes;

public interface SignupService {

    public SignupRes signup(SignupReq req);
}
