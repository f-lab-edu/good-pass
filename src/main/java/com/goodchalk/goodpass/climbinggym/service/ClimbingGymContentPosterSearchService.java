package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymContentPoster;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class ClimbingGymContentPosterSearchService {
    private final ClimbingGymContentRepository climbingGymContentRepository;

    public ClimbingGymContentPoster findByClimbingGymId(Long climbingGymId) {
        InputStream contentInputStream = climbingGymContentRepository.findById(climbingGymId);

        return new ClimbingGymContentPoster(climbingGymId, contentInputStream);
    }
}
