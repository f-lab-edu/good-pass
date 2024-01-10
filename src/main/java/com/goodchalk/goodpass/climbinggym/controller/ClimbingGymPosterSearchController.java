package com.goodchalk.goodpass.climbinggym.controller;

import com.goodchalk.goodpass.climbinggym.controller.dto.response.ClimbingGymPosterDto;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymPosterSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ClimbingGymPosterSearchController {
    private final ClimbingGymPosterSearchService climbingGymPosterSearchService;

    @GetMapping("/climbing-gym/{climbingGymId}/poster")
    public ClimbingGymPosterDto searchClimbingGymPoster(@PathVariable Long climbingGymId) {
        String posterLink = climbingGymPosterSearchService.searchPosterLink(climbingGymId);
        return new ClimbingGymPosterDto(climbingGymId, posterLink);
    }
}
