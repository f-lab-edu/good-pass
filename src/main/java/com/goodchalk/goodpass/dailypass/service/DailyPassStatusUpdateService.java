package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyPassStatusUpdateService {
    private final DailyPassRepository dailyPassRepository;

    public void update(Long dailyPassId) {
        Optional<DailyPass> dailyPassOptional = dailyPassRepository.findById(dailyPassId);
        DailyPass dailyPass = dailyPassOptional.orElseThrow(() ->
                new GoodPassBusinessException("작성된 일일이용서가 없습니다. dailyPassId = " + dailyPassId));
        DailyPass submittedSignatureDailyPass = dailyPass.submittedSignature();

        dailyPassRepository.save(submittedSignatureDailyPass);
    }
}
