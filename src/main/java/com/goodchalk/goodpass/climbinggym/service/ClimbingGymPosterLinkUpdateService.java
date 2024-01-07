package com.goodchalk.goodpass.climbinggym.service;

import com.amazonaws.services.s3.AmazonS3;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymPosterRepository;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClimbingGymPosterLinkUpdateService {
    private final ClimbingGymRepository climbingGymRepository;
    private final ClimbingGymPosterRepository climbingGymPosterRepository;

    public ClimbingGym update(Long climbingGymId) {
        String posterLink = climbingGymPosterRepository.findLink(climbingGymId);
        if (posterLink == null || posterLink.isEmpty()) {
            throw new GoodPassBusinessException("climbingGymId에 대한 poster 파일이 존재하지 않습니다. climbingGymId = " + climbingGymId);
        }

        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(climbingGymId);
        ClimbingGym climbingGym = climbingGymOptional.orElseThrow(()
                -> new GoodPassBusinessException("climbingGymId가 존재하지 않습니다. climbingGymId = " + climbingGymId));

        climbingGym.updatePosterLink(posterLink);
        return climbingGym;
    }
}
