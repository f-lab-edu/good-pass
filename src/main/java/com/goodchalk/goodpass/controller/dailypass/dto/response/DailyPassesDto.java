package com.goodchalk.goodpass.controller.dailypass.dto.response;

import com.goodchalk.goodpass.service.domain.DailyPass;
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
