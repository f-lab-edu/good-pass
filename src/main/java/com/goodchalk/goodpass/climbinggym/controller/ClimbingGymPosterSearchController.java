package com.goodchalk.goodpass.climbinggym.controller;

import com.goodchalk.goodpass.climbinggym.service.ClimbingGymPosterSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ClimbingGymPosterSearchController {
    private final ClimbingGymPosterSearchService climbingGymPosterSearchService;

    @GetMapping("/climbingGymPoster/{climbingGymId}")
    public String searchClimbingGymPoster(@PathVariable Long climbingGymId) {
        return climbingGymPosterSearchService.searchPosterLink(climbingGymId);
    }
}
