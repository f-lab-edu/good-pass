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
public class DailyPassSearchService {
    public static final List<DailyPass> EMPTY_LIST_DAIL_PASS = new ArrayList<>();

    private final DailyPassRepository dailyPassRepository;
    private final ClimbingGymRepository climbingGymRepository;

    public List<DailyPass> findAll(Long climbingGymId) {
        if (!climbingGymRepository.contain(climbingGymId)) {
            throw new RuntimeException("해당 클라이밍장은 등록되어 있지 않습니다.");
        }

        return dailyPassRepository.findAll(climbingGymId);
    }

    public DailyPass findBy(Long dailyPassId) {
        return dailyPassRepository.findBy(dailyPassId);
    }
}

