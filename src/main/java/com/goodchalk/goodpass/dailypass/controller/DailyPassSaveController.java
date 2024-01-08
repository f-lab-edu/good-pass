package com.goodchalk.goodpass.dailypass.controller;

import com.goodchalk.goodpass.dailypass.controller.dto.request.DailyPassSaveRequestDto;
import com.goodchalk.goodpass.dailypass.controller.dto.response.DailyPassSignatureDto;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.service.DailyPassSaveService;
import com.goodchalk.goodpass.dailypass.service.dto.DailyPassCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daily-pass")
@RequiredArgsConstructor
public class DailyPassSaveController {
    private final DailyPassSaveService dailyPassSaveService;

    @PostMapping
    public DailyPassSignatureDto save(@RequestBody DailyPassSaveRequestDto dailyPassSaveRequestDto) {
        DailyPassCreator dailyPassCreator = dailyPassSaveRequestDto.toCreator();
        DailyPass dailyPass = dailyPassSaveService.save(dailyPassCreator);

        return DailyPassSignatureDto.from(dailyPass);
    }


}
