package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymPosterSearchService {
    private final ClimbingGymRepository climbingGymRepository;

    public String searchPosterLink(Long climbingGymId) {
        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(climbingGymId);
        ClimbingGym climbingGym = climbingGymOptional.orElseThrow(()
                -> new GoodPassBusinessException("등록되지 않은 climbingGymId 입니다. climbingGymId = " + climbingGymId));

        String posterLink = climbingGym.getPosterLink();
        if (posterLink == null || posterLink.isEmpty()) {
            return "";
        }

        return posterLink;
    }
}
