package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyPassSearchService {
    private final DailyPassRepository dailyPassRepository;

    public DailyPass findDailyPass(Long id) {
        Optional<DailyPass> dailyPassOptional = dailyPassRepository.findById(id);
        return dailyPassOptional.orElseThrow(()
                -> new GoodPassBusinessException("일일이용동의서 정보가 존재하지 않습니다. id = " + id));
    }
}
