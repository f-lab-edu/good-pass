package com.goodchalk.goodpass.controller.dailypass;

import com.goodchalk.goodpass.controller.dailypass.dto.response.DailyPassesDto;
import com.goodchalk.goodpass.service.dailypass.DailyPassSearchService;
import com.goodchalk.goodpass.service.domain.DailyPass;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/{climbingGymId}/admin/daily-pass")
public class DailyPassAdminController {
    private final DailyPassSearchService dailyPassSearchService;
    @GetMapping
    public DailyPassesDto searchClimbingGymDailyPasses(@PathVariable("climbingGymId") Long climbingGymId) {
        List<DailyPass> dailyPasses = dailyPassSearchService.searchByClimbingGymId(climbingGymId);

        return DailyPassesDto.builder()
                .dailyPasses(dailyPasses)
                .build();
    }
}