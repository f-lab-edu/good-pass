package com.goodchalk.goodpass.dailypass.service.dto;

import com.goodchalk.goodpass.dailypass.domain.Contract;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.SignatureStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Builder
public class DailyPassCreator {
    private final Long climbingGymId;
    private final String userName;
    private final String contact;
    private final Contract dailyUseGymContract;
    private final Contract privacyContract;
    private final LocalDateTime submitTime;


    public DailyPass createNoSignatureDailyPass() {
        return DailyPass.builder()
                .climbingGymId(climbingGymId)
                .signatureStatus(SignatureStatus.NOT_SUBMIT)
                .userName(userName)
                .contact(contact)
                .dailyUseContract(dailyUseGymContract)
                .privacyContract(privacyContract)
                .submitTime(submitTime)
                .build();
    }
}
