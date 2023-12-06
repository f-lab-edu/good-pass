package com.goodchalk.goodpass.controller.dailypass;

import com.goodchalk.goodpass.domain.DailyPass;
import com.goodchalk.goodpass.dto.response.DailyPassListInClimbingGym;
import com.goodchalk.goodpass.service.DailyPassSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public DailyPassListInClimbingGym listUpDailyPass(@PathVariable("climbingGymId") Long climbingGymId) {
        List<DailyPass> dailyPasses = dailyPassSearchService.findAll(climbingGymId);
        return DailyPassListInClimbingGym.builder()
                .dailyPasses(dailyPasses)
                .build();
    }
}
