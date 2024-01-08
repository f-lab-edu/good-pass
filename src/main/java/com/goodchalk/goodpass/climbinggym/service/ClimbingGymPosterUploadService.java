package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymPoster;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymPosterRepository;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymPosterUploadService {
    private final ClimbingGymPosterRepository climbingGymPosterRepository;
    private final ClimbingGymRepository climbingGymRepository;

    public void save(ClimbingGymPoster climbingGymPoster) {
        Long climbingGymId = climbingGymPoster.getClimbingGymId();
        Optional<ClimbingGym> climbingGym = climbingGymRepository.findById(climbingGymId);
        if (climbingGym.isEmpty()) {
            throw new GoodPassBusinessException("존재하지 않는 climbingGymId 입니다. climbingGymId = " + climbingGymId);
        }

        climbingGymPosterRepository.upload(climbingGymPoster);
    }
}
