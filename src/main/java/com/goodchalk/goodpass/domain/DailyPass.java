package com.goodchalk.goodpass.domain;

import lombok.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class DailyPass {
    private static Long id = 0L;

    private final Long dailyPassId;
    private final Long climbingGymId;
    private final String userName;
    private final String contact;
    private final String dailyUseContract;
    private final String privacyContract;
    private final String submitTime;

    public static DailyPass create(Long climbingGymId, String userName, String contact, String dailyUseContract, String privacyContract, String submitTime) {
        return new DailyPass(id++, climbingGymId, userName, contact, dailyUseContract, privacyContract, submitTime);
    }


}
