package com.goodchalk.goodpass.controller.dailypass;

import com.goodchalk.goodpass.controller.dailypass.dto.response.DailyPassSaveFinishDto;
import com.goodchalk.goodpass.controller.dailypass.dto.response.DailyPassSaveFormDto;
import com.goodchalk.goodpass.controller.dailypass.dto.response.DailyPassSignatureDto;
import com.goodchalk.goodpass.exception.domain.DailyPassSaveFailException;
import com.goodchalk.goodpass.exception.infra.NotImplementedException;
import com.goodchalk.goodpass.service.climbinggym.ClimbingGymSearchService;
import com.goodchalk.goodpass.service.dailypass.DailyPassSaveService;
import com.goodchalk.goodpass.service.dailypass.DailyPassSearchService;
import com.goodchalk.goodpass.service.dailypass.dto.DailyPassSaveDto;
import com.goodchalk.goodpass.service.domain.DailyPass;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.core.support.FragmentNotImplementedException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{climbingGymId}/daily-pass")
@RequiredArgsConstructor
public class DailyPassGuestController {
    private final DailyPassSearchService dailyPassSearchService;
    private final DailyPassSaveService dailyPassSaveService;
    private final ClimbingGymSearchService climbingGymSearchService;

    @GetMapping("/save-form")
    public DailyPassSaveFormDto showSaveForm(@PathVariable("climbingGymId") Long climbingGymId) {
        return new DailyPassSaveFormDto(climbingGymId);
    }

    @GetMapping("/save")
    public DailyPassSaveFinishDto showSaveComplete(@PathVariable("climbingGymId") Long climbingGymId) {
        String climbingGymName = climbingGymSearchService.findClimbingGymName(climbingGymId);
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
    public DailyPassSignatureDto save(@PathVariable("climbingGymId") Long climbingGymId, @RequestBody DailyPassSaveDto dailyPassSaveDto) {
        DailyPass dailyPass = dailyPassSaveService.save(climbingGymId, dailyPassSaveDto);
        Long dailyPassId = dailyPass.getId();
        if (dailyPassId == null) {
            throw new DailyPassSaveFailException();
        }

        return DailyPassSignatureDto.builder()
                .climbingGymId(climbingGymId)
                .dailyPassId(dailyPassId)
                .build();
    }

    @PostMapping("/save-signature")
    public DailyPassSaveFinishDto saveSignature(@PathVariable("climbingGymId") Long climbingGymId) {
        throw new NotImplementedException();
    }
}
