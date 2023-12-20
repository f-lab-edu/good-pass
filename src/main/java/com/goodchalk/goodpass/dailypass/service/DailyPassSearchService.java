package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.climbinggym.service.ClimbingGymValidateService;
import com.goodchalk.goodpass.domain.model.DailyPass;
import com.goodchalk.goodpass.domain.repository.DailyPassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyPassSearchService {
    private final DailyPassRepository dailyPassRepository;
    private final ClimbingGymValidateService climbingGymValidateService;

    public List<DailyPass> searchByClimbingGymId(Long climbingGymId) {
        climbingGymValidateService.validExist(climbingGymId);

        return dailyPassRepository.findByClimbingGymId(climbingGymId);
    }
}
