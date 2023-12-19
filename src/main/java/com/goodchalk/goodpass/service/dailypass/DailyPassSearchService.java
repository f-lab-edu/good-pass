package com.goodchalk.goodpass.service.dailypass;

import com.goodchalk.goodpass.service.climbinggym.ClimbingGymValidateService;
import com.goodchalk.goodpass.service.domain.DailyPass;
import com.goodchalk.goodpass.service.repository.DailyPassRepository;
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
