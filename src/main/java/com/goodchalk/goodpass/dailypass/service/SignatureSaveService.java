package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.controller.dto.request.DailyPassSaveRequestDto;
import com.goodchalk.goodpass.dailypass.domain.*;
import com.goodchalk.goodpass.dailypass.service.dto.SignatureDto;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SignatureSaveService {
    private final SignatureRepository signatureRepository;
    private final SignatureFileNameConverter signatureFileNameConverter = new SignatureFileNameConverter(15);

    private final DailyPassRepository dailyPassRepository;

    public void save(SignatureDto signatureDto) {
        Signature signature = signatureDto.toSignature();
        String signatureFileName = signatureFileNameConverter.convert(signature);

        signatureRepository.upload(signatureFileName, signature.getSignatureInputStream());
    }
}
