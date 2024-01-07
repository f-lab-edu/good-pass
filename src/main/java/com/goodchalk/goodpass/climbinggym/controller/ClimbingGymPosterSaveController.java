package com.goodchalk.goodpass.climbinggym.controller;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymPoster;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymPosterRepository;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymPosterLinkUpdateService;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymPosterSaveService;
import com.goodchalk.goodpass.exception.GoodPassSystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequiredArgsConstructor
public class ClimbingGymPosterSaveController {
    private final ClimbingGymPosterSaveService climbingGymPosterSaveService;
    private final ClimbingGymPosterLinkUpdateService climbingGymPosterLinkUpdateService;
    @PostMapping("/climbingGymPoster/{climbingGymId}")
    public String saveClimbingGymPoster(@PathVariable Long climbingGymId, @RequestParam MultipartFile climbingGymPosterFile) {
        ClimbingGymPoster climbingGymPoster = ClimbingGymPoster.of(climbingGymId, climbingGymPosterFile);

        climbingGymPosterSaveService.save(climbingGymPoster);
        climbingGymPosterLinkUpdateService.update(climbingGymId);

        return climbingGymId.toString();
    }
}