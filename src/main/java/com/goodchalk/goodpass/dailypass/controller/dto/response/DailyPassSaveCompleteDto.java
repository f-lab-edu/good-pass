package com.goodchalk.goodpass.dailypass.controller.dto.response;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymContentPoster;
import com.goodchalk.goodpass.exception.GoodPassSystemException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.io.InputStream;

@RequiredArgsConstructor
@Builder
public class DailyPassSaveCompleteDto {
    private final String climbingGymName;
    private final String message;
    private final InputStream inputStream;

    public static DailyPassSaveCompleteDto from(ClimbingGymContentPoster climbingGymContentPoster) {
        throw new GoodPassSystemException("미구현");
    }
}
