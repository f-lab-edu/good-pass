package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DailyPassStatusUpdateService {
    private final DailyPassRepository dailyPassRepository;

    public void update(Long dailyPassId) {
        DailyPass dailyPass = dailyPassRepository.findById(dailyPassId).orElseThrow(() ->
                new GoodPassBusinessException("작성된 일일이용서가 없습니다. dailyPassId = " + dailyPassId));

        dailyPass.updateSignatureSubmitted();

        dailyPassRepository.save(dailyPass);
    }
}
