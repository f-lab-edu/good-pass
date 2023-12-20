package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.climbinggym.service.ClimbingGymValidateService;
import com.goodchalk.goodpass.domain.model.DailyPass;
import com.goodchalk.goodpass.domain.repository.DailyPassRepository;
import com.goodchalk.goodpass.dailypass.service.dto.DailyPassSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DailyPassSaveService {
    private final DailyPassRepository dailyPassRepository;
    private final ClimbingGymValidateService climbingGymValidateService;

    public DailyPass save(Long climbingGymId, DailyPassSaveDto dailyPassSaveDto) {
        climbingGymValidateService.validExist(climbingGymId);

        DailyPass dailyPass = dailyPassSaveDto.createDailyPass(climbingGymId);

        return dailyPassRepository.save(dailyPass);
    }
}
