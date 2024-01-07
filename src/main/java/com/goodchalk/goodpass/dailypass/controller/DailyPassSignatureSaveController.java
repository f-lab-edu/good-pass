package com.goodchalk.goodpass.dailypass.controller;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymContentMessage;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymContentPoster;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymContentMessageSearchService;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymContentPosterSearchService;
import com.goodchalk.goodpass.climbinggym.controller.dto.response.ClimbingGymContentResponseDto;
import com.goodchalk.goodpass.dailypass.controller.dto.response.DailyPassSignatureDto;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.service.DailyPassSearchService;
import com.goodchalk.goodpass.dailypass.service.DailyPassStatusUpdateService;
import com.goodchalk.goodpass.dailypass.service.SignatureSaveService;
import com.goodchalk.goodpass.dailypass.service.dto.SignatureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("daily-pass/signature/{dailyPassId}")
public class DailyPassSignatureSaveController {
    private final ClimbingGymContentMessageSearchService climbingGymContentMessageSearchService;
    private final ClimbingGymContentPosterSearchService climbingGymContentPosterSearchService;
    private final SignatureSaveService signatureSaveService;
    private final DailyPassSearchService dailyPassSearchService;
    private final DailyPassStatusUpdateService dailyPassStatusUpdateService;
    @GetMapping
    public ClimbingGymContentResponseDto showSaveComplete(@PathVariable("dailyPassId") Long dailyPassId) {
        DailyPass dailyPass = dailyPassSearchService.findDailyPass(dailyPassId);
        Long climbingGymId = dailyPass.getClimbingGymId();
        ClimbingGymContentMessage climbingGymContentMessage = climbingGymContentMessageSearchService.searchBy(climbingGymId);
        ClimbingGymContentPoster climbingGymContentPoster = climbingGymContentPosterSearchService.findByClimbingGymId(climbingGymId);

        return ClimbingGymContentResponseDto.of(climbingGymContentMessage, climbingGymContentPoster);
    }

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