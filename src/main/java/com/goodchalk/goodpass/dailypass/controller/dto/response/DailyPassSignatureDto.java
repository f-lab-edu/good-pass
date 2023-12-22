package com.goodchalk.goodpass.dailypass.controller.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;

@RequiredArgsConstructor
@Builder
public class DailyPassSignatureDto {
    private final Long climbingGymId;
    private final Long dailyPassId;
    private final Link redirectUrl;
}
