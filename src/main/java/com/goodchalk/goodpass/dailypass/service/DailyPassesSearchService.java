package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyPassesSearchService {
    private final DailyPassRepository dailyPassRepository;
    private final ClimbingGymRepository climbingGymRepository;

    public List<DailyPass> searchByClimbingGymId(Long climbingGymId) {
        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(climbingGymId);
        climbingGymOptional.orElseThrow(() -> new RuntimeException("등록되지 않은 클라이밍장입니다. climbingGymId=" + climbingGymId));

        return dailyPassRepository.findByClimbingGymId(climbingGymId);
    }
}
