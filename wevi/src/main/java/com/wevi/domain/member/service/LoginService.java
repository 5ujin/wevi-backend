package com.wevi.domain.member.service;

import com.wevi.domain.member.dto.LoginReq;
import com.wevi.domain.member.dto.LoginRes;

public interface LoginService {
    public LoginRes login(LoginReq loginReq);
}
