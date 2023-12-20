package com.goodchalk.goodpass.dailypass.controller.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class DailyPassSaveFinishDto {
    private final String climbingGymName;
    private final String message;
}
