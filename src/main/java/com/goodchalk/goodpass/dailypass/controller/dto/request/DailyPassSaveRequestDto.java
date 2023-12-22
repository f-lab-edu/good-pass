package com.goodchalk.goodpass.dailypass.controller.dto.request;

import com.goodchalk.goodpass.dailypass.service.dto.DailyPassSaveDto;
import com.goodchalk.goodpass.domain.model.ClimbingGym;
import com.goodchalk.goodpass.domain.model.Contract;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Builder
public class DailyPassSaveRequestDto {
    private final String userName;
    private final String contact;
    private final Contract dailyUseGymContract;
    private final Contract privacyContract;
    private final LocalDateTime submitTime;

    public DailyPassSaveDto createDailyPassSaveDto(Long climbingGymId) {
        return DailyPassSaveDto.builder()
                .climbingGymId(climbingGymId)
                .userName(userName)
                .contact(contact)
                .dailyUseGymContract(dailyUseGymContract)
                .privacyContract(privacyContract)
                .submitTime(submitTime)
                .build();
    }
}
