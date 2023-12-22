package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.domain.model.ClimbingGym;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import com.goodchalk.goodpass.domain.repository.ClimbingGymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymInfoSearchService {
    private final ClimbingGymRepository climbingGymRepository;

    public String findClimbingGymName(Long climbingGymId) {
        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(climbingGymId);
        ClimbingGym climbingGym = climbingGymOptional.orElseThrow(GoodPassBusinessException::new);
        return climbingGym.getClimbingGymName();
    }
}
