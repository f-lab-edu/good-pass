package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymPoster;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClimbingGymPosterSaveService {
    private final ClimbingGymPosterUploadService climbingGymPosterUploadService;
    private final ClimbingGymPosterLinkUpdateService climbingGymPosterLinkUpdateService;

    public void save(ClimbingGymPoster climbingGymPoster) {
        climbingGymPosterUploadService.save(climbingGymPoster);
        climbingGymPosterLinkUpdateService.update(climbingGymPoster.getClimbingGymId());
    }
}
