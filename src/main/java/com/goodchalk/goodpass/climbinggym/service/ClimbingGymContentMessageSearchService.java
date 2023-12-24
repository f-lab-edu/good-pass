package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymContentMessage;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymContentMessageSearchService {
    private final ClimbingGymRepository climbingGymRepository;
    public ClimbingGymContentMessage searchBy(Long climbingGymId) {
        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(climbingGymId);
        ClimbingGym climbingGym = climbingGymOptional.orElseThrow(()
                -> new GoodPassBusinessException("등록되지 않은 클라이밍장을 조회했습니다. id = " + climbingGymId));
        return climbingGym.toContentMessage();
    }
}
