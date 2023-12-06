package com.goodchalk.goodpass.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class DailyPassSaveDto {
    private final String userName;
    private final String contact;
    private final String dailyUseGymContract;
    private final String privacyContract;
    private final String submitTime;
}