package com.goodchalk.goodpass.service.dailypass.dto;

import com.goodchalk.goodpass.service.domain.ClimbingGym;
import com.goodchalk.goodpass.service.domain.Contract;
import com.goodchalk.goodpass.service.domain.DailyPass;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Builder
public class DailyPassSaveDto {
    private final String userName;
    private final String contact;
    private final Contract dailyUseGymContract;
    private final Contract privacyContract;
    private final LocalDateTime submitTime;

    public DailyPass createDailyPass(Long climbingGymId) {
        return DailyPass.builder()
                .climbingGymId(climbingGymId)
                .userName(userName)
                .contact(contact)
                .dailyUseContract(dailyUseGymContract)
                .privacyContract(privacyContract)
                .submitTime(submitTime)
                .build();
    }
}
