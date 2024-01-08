package com.goodchalk.goodpass.dailypass.controller.dto.request;

import com.goodchalk.goodpass.dailypass.service.dto.DailyPassCreator;
import com.goodchalk.goodpass.dailypass.domain.Contract;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Builder
public class DailyPassSaveRequestDto {
    private final Long climbingGymId;
    private final String userName;
    private final String contact;
    private final Contract dailyUseGymContract;
    private final Contract privacyContract;
    private final LocalDateTime submitDateTime;

    public DailyPassCreator toCreator() {
        return DailyPassCreator.builder()
                .climbingGymId(climbingGymId)
                .userName(userName)
                .contact(contact)
                .dailyUseGymContract(dailyUseGymContract)
                .privacyContract(privacyContract)
                .submitTime(submitDateTime)
                .build();
    }
}
