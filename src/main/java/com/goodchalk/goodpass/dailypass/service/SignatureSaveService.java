package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.service.dto.SignatureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignatureSaveService {
    private final SignatureUploadService signatureUploadService;
    private final DailyPassStatusUpdateService dailyPassStatusUpdateService;

    public void save(SignatureDto signatureDto) {
        signatureUploadService.upload(signatureDto);

        Long dailyPassId = signatureDto.getDailyPassId();
        dailyPassStatusUpdateService.update(dailyPassId);
    }
}
