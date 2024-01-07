package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.controller.dto.request.DailyPassSaveRequestDto;
import com.goodchalk.goodpass.dailypass.domain.*;
import com.goodchalk.goodpass.dailypass.service.dto.SignatureDto;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import com.goodchalk.goodpass.exception.GoodPassSystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignatureSaveService {
    private final SignatureRepository signatureRepository;

    public void save(SignatureDto signatureDto) {
        Signature signature = signatureDto.toSignature();
        signatureRepository.upload(signature);
    }
}
