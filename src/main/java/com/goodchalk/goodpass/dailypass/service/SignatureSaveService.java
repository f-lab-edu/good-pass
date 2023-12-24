package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.controller.dto.request.DailyPassSaveRequestDto;
import com.goodchalk.goodpass.dailypass.domain.*;
import com.goodchalk.goodpass.dailypass.service.dto.SignatureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignatureSaveService {
    private final SignatureRepository signatureRepository;
    private final DailyPassRepository dailyPassRepository;

    public void save(SignatureDto signatureDto) {
        Signature signature = signatureDto.toSignature();
        signatureRepository.upload(signature);

        DailyPass dailyPassSignatureStatusUpdate = DailyPass.builder()
                .id(signatureDto.getDailyPassId())
                .signatureStatus(SignatureStatus.SUBMIT)
                .build();

        dailyPassRepository.save(dailyPassSignatureStatusUpdate);
    }
}
