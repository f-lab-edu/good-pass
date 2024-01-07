package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.SignatureStatus;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import com.goodchalk.goodpass.dailypass.service.dto.DailyPassCreator;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyPassSaveService {
    private final DailyPassRepository dailyPassRepository;
    private final ClimbingGymRepository climbingGymRepository;

    public DailyPass save(DailyPassCreator dailyPassCreator) {
        Long climbingGymId = dailyPassCreator.getClimbingGymId();

        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(climbingGymId);
        climbingGymOptional.orElseThrow(()->new GoodPassBusinessException("등록된 클라이밍장이 없습니다. id="+climbingGymId));

        DailyPass noSignatureDailyPass = dailyPassCreator.createNoSignatureDailyPass();

        return dailyPassRepository.save(noSignatureDailyPass);
    }
}
