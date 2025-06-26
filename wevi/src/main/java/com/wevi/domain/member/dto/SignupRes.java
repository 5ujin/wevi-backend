package com.wevi.domain.member.dto;

import lombok.Builder;

@Builder
public record SignupRes(
        Long memberId,
        String message
) {}
