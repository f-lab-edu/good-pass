package com.goodchalk.goodpass.dailypass.controller;

import com.goodchalk.goodpass.climbinggym.service.ClimbingGymInfoSearchService;
import com.goodchalk.goodpass.dailypass.controller.dto.request.DailyPassSaveRequestDto;
import com.goodchalk.goodpass.dailypass.controller.dto.response.DailyPassSaveFinishDto;
import com.goodchalk.goodpass.dailypass.controller.dto.response.DailyPassSaveFormDto;
import com.goodchalk.goodpass.dailypass.controller.dto.response.DailyPassSignatureDto;
import com.goodchalk.goodpass.dailypass.service.DailyPassSaveService;
import com.goodchalk.goodpass.dailypass.service.DailyPassSearchService;
import com.goodchalk.goodpass.dailypass.service.dto.DailyPassSaveDto;
import com.goodchalk.goodpass.domain.model.DailyPass;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{climbingGymId}/daily-pass")
@RequiredArgsConstructor
public class DailyPassGuestController {
    private final DailyPassSearchService dailyPassSearchService;
    private final DailyPassSaveService dailyPassSaveService;
    private final ClimbingGymInfoSearchService climbingGymInfoSearchService;

    @GetMapping("/save-form")
    public DailyPassSaveFormDto showSaveForm(@PathVariable("climbingGymId") Long climbingGymId) {
        return new DailyPassSaveFormDto(climbingGymId);
    }

    @GetMapping("/save")
    public DailyPassSaveFinishDto showSaveComplete(@PathVariable("climbingGymId") Long climbingGymId) {
        String climbingGymName = climbingGymInfoSearchService.findClimbingGymName(climbingGymId);
        return new DailyPassSaveFinishDto(climbingGymName, null);
    }

    @GetMapping("/{dailyPassId}/signature-form")
    public DailyPassSignatureDto showSignatureForm(@PathVariable("climbingGymId") Long climbingGymId,
                                                   @PathVariable("dailyPassId") Long dailyPassId) {
        return DailyPassSignatureDto.builder()
                .climbingGymId(climbingGymId)
                .dailyPassId(dailyPassId)
                .build();
    }

    @PostMapping("/save")
    public DailyPassSignatureDto save(@PathVariable("climbingGymId") Long climbingGymId, @RequestBody DailyPassSaveRequestDto dailyPassSaveRequestDto) {
        DailyPassSaveDto dailyPassSaveDto = dailyPassSaveRequestDto.createDailyPassSaveDto(climbingGymId);
        DailyPass dailyPass = dailyPassSaveService.save(dailyPassSaveDto);
        Long dailyPassId = dailyPass.getId();
        if (dailyPassId == null) {
            throw new GoodPassBusinessException();
        }

        return DailyPassSignatureDto.builder()
                .climbingGymId(climbingGymId)
                .dailyPassId(dailyPassId)
                .build();
    }

    @PostMapping("/save-signature")
    public DailyPassSaveFinishDto saveSignature(@PathVariable("climbingGymId") Long climbingGymId) {
        throw new GoodPassBusinessException();
    }
}
