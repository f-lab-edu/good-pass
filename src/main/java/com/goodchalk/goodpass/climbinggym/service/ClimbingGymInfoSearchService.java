package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymInfoSearchService {
    private final ClimbingGymRepository climbingGymRepository;

    public String findClimbingGymName(Long climbingGymId) {
        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(climbingGymId);
        ClimbingGym climbingGym = climbingGymOptional.orElseThrow(()
                -> new GoodPassBusinessException("등록되지 않은 클라이밍장 ID 입니다. id=" + climbingGymId));
        return climbingGym.getClimbingGymName();
    }
}
