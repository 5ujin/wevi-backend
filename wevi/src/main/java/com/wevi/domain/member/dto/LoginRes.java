package com.wevi.domain.member.dto;

import lombok.Builder;

@Builder
public record LoginRes(
        String accessToken,
        String refreshToken
) {}
