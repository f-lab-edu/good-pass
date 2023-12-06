package com.goodchalk.goodpass.dto.response;

import com.goodchalk.goodpass.domain.DailyPass;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Builder
public class DailyPassListInClimbingGym {
    private final List<DailyPass> dailyPasses;
}
