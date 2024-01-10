package com.goodchalk.goodpass.dailypass.controller.dto.response;

import com.goodchalk.goodpass.dailypass.domain.Contract;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.SignatureStatus;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Builder
public class DailyPassSaveResponseDto {
    private Long id;
    private Long climbingGymId;
    private SignatureStatus signatureStatus;
    private String userName;
    private String contact;
    private Contract dailyUseContract;
    private Contract privacyContract;

    public static DailyPassSaveResponseDto from(DailyPass dailyPass) {
        return DailyPassSaveResponseDto.builder()
                .id(dailyPass.getId())
                .climbingGymId(dailyPass.getClimbingGymId())
                .contact(dailyPass.getContact())
                .signatureStatus(dailyPass.getSignatureStatus())
                .dailyUseContract(dailyPass.getDailyUseContract())
                .privacyContract(dailyPass.getPrivacyContract())
                .build();
    }
}
