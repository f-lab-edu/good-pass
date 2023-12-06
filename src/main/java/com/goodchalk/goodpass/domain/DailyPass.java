package com.goodchalk.goodpass.domain;

import lombok.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Builder
public class DailyPass {
    private final Long dailyPassId;
    private final Long climbingGymId;
    private final String userName;
    private final String contact;
    private final String dailyUseContract;
    private final String privacyContract;
    private final String submitTime;
}
