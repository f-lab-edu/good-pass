package com.goodchalk.goodpass.controller.dailypass;

import com.goodchalk.goodpass.domain.DailyPass;
import com.goodchalk.goodpass.dto.request.DailyPassSaveDto;
import com.goodchalk.goodpass.dto.response.DailyPassFail;
import com.goodchalk.goodpass.dto.response.DailyPassSaveFinish;
import com.goodchalk.goodpass.dto.response.DailyPassSaveForm;
import com.goodchalk.goodpass.dto.response.DailyPassSignature;
import com.goodchalk.goodpass.service.ClimbingGymSearchService;
import com.goodchalk.goodpass.service.DailyPassSaveService;
import com.goodchalk.goodpass.service.DailyPassSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{climbingGymId}/daily-pass")
@RequiredArgsConstructor
public class DailyPassGuestController {
    private final DailyPassSearchService dailyPassSearchService;
    private final DailyPassSaveService dailyPassSaveService;
    private final ClimbingGymSearchService climbingGymSearchService;

    @GetMapping("/save-form")
    public DailyPassSaveForm showSaveForm(@PathVariable("climbingGymId") Long climbingGymId) {
        return DailyPassSaveForm.builder()
                .climbingGymId(climbingGymId)
                .build();
    }

    @GetMapping("/save")
    public DailyPassSaveFinish showSaveCompete(@PathVariable("climbingGymId") Long climbingGymId) {
        String climbingGymName = climbingGymSearchService.findClimbingGymName(climbingGymId);
        return DailyPassSaveFinish.builder()
                .climbingGymId(climbingGymId)
                .message(climbingGymName)
                .build();
    }

    @GetMapping("/{dailyPassId}/signature-form")
    public DailyPassSignature showSignatureForm(@PathVariable("climbingGymId") Long climbingGymId,
                                    @PathVariable("dailyPassId") Long dailyPassId) {
        return DailyPassSignature.builder()
                .climbingGymId(climbingGymId)
                .dailyPassId(dailyPassId)
                .build();
    }

    @PostMapping("/save")
    public DailyPassSignature save(@PathVariable("climbingGymId") Long climbingGymId, @RequestBody DailyPassSaveDto dailyPassSaveDto) {
        DailyPass dailyPass = dailyPassSaveService.save(climbingGymId, dailyPassSaveDto);
        Long dailyPassId = dailyPass.getDailyPassId();
        if (dailyPassSaveService.isNotRegistered(dailyPassId)) {
            return DailyPassSignature.createSuccess();
        }

        return DailyPassSignature.createFail();
    }

    @PostMapping("/save-signature")
    public DailyPassSaveFinish saveSignature(@PathVariable("climbingGymId") Long climbingGymId) {
        return DailyPassSaveFinish.builder()
                .climbingGymId(climbingGymId)
                .build();
    }
}
