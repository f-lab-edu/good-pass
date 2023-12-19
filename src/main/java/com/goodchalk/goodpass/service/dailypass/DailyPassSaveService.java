package com.goodchalk.goodpass.service.dailypass;

import com.goodchalk.goodpass.service.climbinggym.ClimbingGymValidateService;
import com.goodchalk.goodpass.service.domain.DailyPass;
import com.goodchalk.goodpass.service.repository.DailyPassRepository;
import com.goodchalk.goodpass.service.dailypass.dto.DailyPassSaveDto;
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
