package com.goodchalk.goodpass.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class DailyPassSignature {
    private final Long climbingGymId;
    private final Long dailyPassId;

    public static DailyPassSignature createSuccess() {
        return null;
    }

    public static DailyPassSignature createFail() {
        return null;
    }
}
