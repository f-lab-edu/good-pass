package com.goodchalk.goodpass.controller.dailypass.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class DailyPassSaveFormDto {
    private final Long climbingGymId;
}
