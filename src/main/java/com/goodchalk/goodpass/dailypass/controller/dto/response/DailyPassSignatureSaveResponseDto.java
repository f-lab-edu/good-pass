package com.goodchalk.goodpass.dailypass.controller.dto.response;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.SignatureStatus;
import lombok.Builder;

@Builder
public class DailyPassSignatureSaveResponseDto {
    private Long dailyPassId;
    private SignatureStatus signatureStatus;
    public static DailyPassSignatureSaveResponseDto from(DailyPass dailyPass) {
        return DailyPassSignatureSaveResponseDto.builder()
                .dailyPassId(dailyPass.getId())
                .signatureStatus(dailyPass.getSignatureStatus())
                .build();
    }
}
