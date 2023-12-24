package com.goodchalk.goodpass.climbinggym.controller;


import com.goodchalk.goodpass.climbinggym.service.ClimbingGymInfoSearchService;
import com.goodchalk.goodpass.climbinggym.controller.dto.response.ClimbingGymNameDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequiredArgsConstructor
public class ClimbingGymNameSearchController {
    private final ClimbingGymInfoSearchService climbingGymInfoSearchService;
    @GetMapping("/{climbingGymId}")
    public ClimbingGymNameDto showSaveForm(@PathVariable("climbingGymId") Long climbingGymId) {
        String climbingGymName = climbingGymInfoSearchService.findClimbingGymName(climbingGymId);
        return new ClimbingGymNameDto(climbingGymId, climbingGymName);
    }
}
