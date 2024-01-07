package com.goodchalk.goodpass.dailypass.controller;

import com.goodchalk.goodpass.dailypass.controller.dto.response.DailyPassesDto;
import com.goodchalk.goodpass.dailypass.service.DailyPassesSearchService;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/daily-passes")
public class DailyPassSearchController {
    private final DailyPassesSearchService dailyPassesSearchService;
//    @GetMapping
//    public DailyPassesDto searchClimbingGymDailyPasses(@RequestParam("climbingGymId") Long climbingGymId) {
//        List<DailyPass> dailyPasses = dailyPassesSearchService.searchByClimbingGymId(climbingGymId);
//
//        return new DailyPassesDto(dailyPasses);
//    }

    @GetMapping
    public DailyPassesDto searchClimbingGymDailyPassesWithPage(@RequestParam("climbingGymId") Long climbingGymId,
                                                               @RequestParam("page") int page,
                                                               @RequestParam("size") int size) {
        Page<DailyPass> dailyPassPage = dailyPassesSearchService.searchByClimbingGymIdWIthPage(climbingGymId, page, size);

        List<DailyPass> dailyPasses = dailyPassPage.getContent();
        return new DailyPassesDto(dailyPasses);
    }
}