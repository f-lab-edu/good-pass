package com.goodchalk.goodpass.dailypass.controller;

import com.goodchalk.goodpass.climbinggym.service.ClimbingGymContentMessageSearchService;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymContentPosterSearchService;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymInfoSearchService;
import com.goodchalk.goodpass.dailypass.controller.dto.request.DailyPassSaveRequestDto;
import com.goodchalk.goodpass.dailypass.controller.dto.response.DailyPassSignatureDto;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.service.DailyPassSaveService;
import com.goodchalk.goodpass.dailypass.service.DailyPassSearchService;
import com.goodchalk.goodpass.dailypass.service.SignatureSaveService;
import com.goodchalk.goodpass.dailypass.service.dto.DailyPassCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/daily-pass")
@RequiredArgsConstructor
public class DailyPassSaveController {
    private final DailyPassSaveService dailyPassSaveService;
    private final ClimbingGymInfoSearchService climbingGymInfoSearchService;
    private final SignatureSaveService signatureSaveService;
    private final DailyPassSearchService dailyPassSearchService;
    private final ClimbingGymContentMessageSearchService climbingGymContentMessageSearchService;
    private final ClimbingGymContentPosterSearchService climbingGymContentPosterSearchService;

    @PostMapping
    public DailyPassSignatureDto save(@RequestBody DailyPassSaveRequestDto dailyPassSaveRequestDto) {
        DailyPassCreator dailyPassCreator = dailyPassSaveRequestDto.toCreator();
        DailyPass dailyPass = dailyPassSaveService.save(dailyPassCreator);

        return DailyPassSignatureDto.from(dailyPass);
    }


}
