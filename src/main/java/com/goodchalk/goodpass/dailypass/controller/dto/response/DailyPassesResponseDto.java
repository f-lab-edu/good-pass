package com.goodchalk.goodpass.dailypass.controller.dto.response;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class DailyPassesResponseDto {
    private final List<DailyPass> dailyPasses;
}
