package com.goodchalk.goodpass.dailypass.controller.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class DailyPassSaveFormDto {
    private final Long climbingGymId;
}
