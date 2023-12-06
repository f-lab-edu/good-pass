package com.goodchalk.goodpass.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class DailyPassSaveFinish {
    private final Long climbingGymId;
    private final String message;
}
