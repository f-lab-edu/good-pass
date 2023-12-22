package com.goodchalk.goodpass.dailypass.service.dto;

import com.goodchalk.goodpass.dailypass.domain.Contract;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Builder
public class DailyPassSaveDto {
    private final Long climbingGymId;
    private final String userName;
    private final String contact;
    private final Contract dailyUseGymContract;
    private final Contract privacyContract;
    private final LocalDateTime submitTime;


}
