package com.goodchalk.goodpass.dailypass.controller;

import com.goodchalk.goodpass.dailypass.controller.dto.response.DailyPassesDto;
import com.goodchalk.goodpass.dailypass.service.DailyPassSearchService;
import com.goodchalk.goodpass.domain.model.DailyPass;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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