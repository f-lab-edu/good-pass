package com.goodchalk.goodpass.service;

import com.goodchalk.goodpass.domain.DailyPass;
import com.goodchalk.goodpass.dto.request.DailyPassSaveDto;
import com.goodchalk.goodpass.repository.ClimbingGymRepository;
import com.goodchalk.goodpass.repository.DailyPassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DailyPassSaveService {
    public static final List<DailyPass> EMPTY_LIST_DAIL_PASS = new ArrayList<>();

    private final DailyPassRepository dailyPassRepository;
    private final ClimbingGymRepository climbingGymRepository;

    public DailyPass save(Long climbingGymId, DailyPassSaveDto dailyPassSaveDto) {
        DailyPass dailyPass = DailyPass.builder()
                .climbingGymId(climbingGymId)
                .userName(dailyPassSaveDto.getUserName())
                .contact(dailyPassSaveDto.getContact())
                .dailyUseContract(dailyPassSaveDto.getDailyUseGymContract())
                .privacyContract(dailyPassSaveDto.getPrivacyContract())
                .submitTime(dailyPassSaveDto.getSubmitTime())
                .build();

        if (!climbingGymRepository.contain(dailyPass.getClimbingGymId())) {
            throw new RuntimeException("dailyPass를 저장할 climbingGym이 존재하지 않습니다.");
        }

        return dailyPassRepository.save(dailyPass);
    }

    public boolean isNotRegistered(Long dailyPassId) {
        DailyPass dailyPass = dailyPassRepository.findBy(dailyPassId);
        return dailyPass.getDailyPassId() != null;
    }
}

