package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.domain.*;
import com.goodchalk.goodpass.dailypass.service.dto.SignatureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignatureUploadService {
    private final SignatureRepository signatureRepository;

    public void upload(SignatureDto signatureDto) {
        Signature signature = signatureDto.toSignature();
        signatureRepository.upload(signature);
    }
}
