package com.goodchalk.goodpass.dailypass.controller.dto.response;

import com.goodchalk.goodpass.domain.model.DailyPass;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Builder
public class DailyPassesDto {
    private final List<DailyPass> dailyPasses;
}
