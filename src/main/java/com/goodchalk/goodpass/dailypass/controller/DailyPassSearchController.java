package com.goodchalk.goodpass.dailypass.controller;

import com.goodchalk.goodpass.dailypass.controller.dto.response.DailyPassesResponseDto;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.service.DailyPassesSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DailyPassSearchController {
    private final DailyPassesSearchService dailyPassesSearchService;

    @GetMapping("/daily-passes")
    public DailyPassesResponseDto searchClimbingGymDailyPassesWithPage(@RequestParam("climbingGymId") Long climbingGymId,
                                                                       @RequestParam("page") int page,
                                                                       @RequestParam("size") int size) {
        Page<DailyPass> dailyPassPage = dailyPassesSearchService.searchByClimbingGymIdWIthPage(climbingGymId, page, size);

        List<DailyPass> dailyPasses = dailyPassPage.getContent();
        return new DailyPassesResponseDto(dailyPasses);
    }
}