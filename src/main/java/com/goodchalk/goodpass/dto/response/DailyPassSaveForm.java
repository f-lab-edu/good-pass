package com.goodchalk.goodpass.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class DailyPassSaveForm {
    private final Long climbingGymId;
}
