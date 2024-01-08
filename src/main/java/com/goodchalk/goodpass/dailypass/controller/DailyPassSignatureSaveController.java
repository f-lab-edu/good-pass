package com.goodchalk.goodpass.dailypass.controller;

import com.goodchalk.goodpass.dailypass.controller.dto.response.DailyPassSignatureDto;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.service.DailyPassSearchService;
import com.goodchalk.goodpass.dailypass.service.DailyPassStatusUpdateService;
import com.goodchalk.goodpass.dailypass.service.SignatureSaveService;
import com.goodchalk.goodpass.dailypass.service.dto.SignatureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("daily-pass/signature/{dailyPassId}")
public class DailyPassSignatureSaveController {
    private final SignatureSaveService signatureSaveService;
    private final DailyPassSearchService dailyPassSearchService;
    private final DailyPassStatusUpdateService dailyPassStatusUpdateService;

    @PostMapping
    public DailyPassSignatureDto saveSignature(@PathVariable("dailyPassId") Long dailyPassId,
                                               @RequestParam MultipartFile signatureFile) {
        SignatureDto signatureDto = new SignatureDto(dailyPassId, signatureFile);
        signatureSaveService.save(signatureDto);

        dailyPassStatusUpdateService.update(dailyPassId);
        DailyPass dailyPass = dailyPassSearchService.findDailyPass(dailyPassId);

        return DailyPassSignatureDto.from(dailyPass);
    }
}