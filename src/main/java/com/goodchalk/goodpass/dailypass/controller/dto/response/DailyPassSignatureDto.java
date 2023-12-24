package com.goodchalk.goodpass.dailypass.controller.dto.response;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;

@RequiredArgsConstructor
@Builder
public class DailyPassSignatureDto {
    private final Long climbingGymId;
    private final Long dailyPassId;
    private final Link redirectUrl;

    public static DailyPassSignatureDto from(DailyPass dailyPass) {
        return DailyPassSignatureDto.builder()
                .dailyPassId(dailyPass.getId())
                .climbingGymId(dailyPass.getClimbingGymId())
                .build();
    }
}
