package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.domain.model.ClimbingGym;
import com.goodchalk.goodpass.domain.model.DailyPass;
import com.goodchalk.goodpass.domain.repository.ClimbingGymRepository;
import com.goodchalk.goodpass.domain.repository.DailyPassRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyPassSearchService {
    private final DailyPassRepository dailyPassRepository;
    private final ClimbingGymRepository climbingGymRepository;

    public List<DailyPass> searchByClimbingGymId(Long climbingGymId) {
        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(climbingGymId);
        climbingGymOptional.orElseThrow(GoodPassBusinessException::new);

        return dailyPassRepository.findByClimbingGymId(climbingGymId);
    }
}
