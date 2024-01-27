package com.goodchalk.goodpass.climbinggym.controller;

import com.goodchalk.goodpass.climbinggym.controller.dto.response.ClimbingGymPosterDto;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymPoster;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymPosterSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class ClimbingGymPosterSaveController {
    private final ClimbingGymPosterSaveService climbingGymPosterSaveService;
    @PostMapping("/climbing-gym/{climbingGymId}/poster")
    public ClimbingGymPosterDto saveClimbingGymPoster(@PathVariable Long climbingGymId, @RequestParam MultipartFile climbingGymPosterFile) {
        ClimbingGymPoster climbingGymPoster = ClimbingGymPoster.of(climbingGymId, climbingGymPosterFile);

        climbingGymPosterSaveService.save(climbingGymPoster);

        return new ClimbingGymPosterDto(climbingGymId, null);
    }
}