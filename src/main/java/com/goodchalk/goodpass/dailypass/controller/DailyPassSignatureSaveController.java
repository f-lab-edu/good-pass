package com.goodchalk.goodpass.dailypass.controller;

import com.goodchalk.goodpass.dailypass.controller.dto.response.DailyPassSignatureSaveResponseDto;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.service.DailyPassSearchService;
import com.goodchalk.goodpass.dailypass.service.SignatureSaveService;
import com.goodchalk.goodpass.dailypass.service.dto.SignatureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class DailyPassSignatureSaveController {
    private final DailyPassSearchService dailyPassSearchService;
    private final SignatureSaveService signatureSaveService;

    @PostMapping("daily-pass/signature/{dailyPassId}")
    public DailyPassSignatureSaveResponseDto saveSignature(@PathVariable("dailyPassId") Long dailyPassId,
                                                  @RequestParam MultipartFile signatureFile) {
        SignatureDto signatureDto = new SignatureDto(dailyPassId, signatureFile);
        signatureSaveService.save(signatureDto);
        DailyPass dailyPass = dailyPassSearchService.findDailyPass(dailyPassId);

        return DailyPassSignatureSaveResponseDto.from(dailyPass);
    }
}