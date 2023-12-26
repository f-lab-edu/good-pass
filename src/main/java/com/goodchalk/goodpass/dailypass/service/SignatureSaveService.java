package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.controller.dto.request.DailyPassSaveRequestDto;
import com.goodchalk.goodpass.dailypass.domain.*;
import com.goodchalk.goodpass.dailypass.service.dto.SignatureDto;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignatureSaveService {
    private final SignatureRepository signatureRepository;
    private final DailyPassRepository dailyPassRepository;

    public void save(SignatureDto signatureDto) {
        Signature signature = signatureDto.toSignature();
        signatureRepository.upload(signature);

        Long dailyPassId = signatureDto.getDailyPassId();
        Optional<DailyPass> dailyPassOptional = dailyPassRepository.findById(dailyPassId);
        DailyPass dailyPass = dailyPassOptional.orElseThrow(() ->
                new GoodPassBusinessException("작성된 일일이용서가 없습니다. dailyPassId = " + dailyPassId));
        DailyPass submittedSignatureDailyPass = dailyPass.submittedSignature();

        dailyPassRepository.save(submittedSignatureDailyPass);
    }
}
