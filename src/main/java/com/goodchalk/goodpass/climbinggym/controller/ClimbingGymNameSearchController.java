package com.goodchalk.goodpass.climbinggym.controller;


import com.goodchalk.goodpass.climbinggym.controller.dto.response.ClimbingGymNameDto;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymInfoSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ClimbingGymNameSearchController {
    private final ClimbingGymInfoSearchService climbingGymInfoSearchService;
    @GetMapping("/climbingGymName/{climbingGymId}")
    public ClimbingGymNameDto showSaveForm(@PathVariable("climbingGymId") Long climbingGymId) {
        String climbingGymName = climbingGymInfoSearchService.findClimbingGymName(climbingGymId);
        return new ClimbingGymNameDto(climbingGymId, climbingGymName);
    }
}
