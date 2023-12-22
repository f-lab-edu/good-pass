package com.goodchalk.goodpass.dailypass.controller;

import com.goodchalk.goodpass.climbinggym.service.ClimbingGymInfoSearchService;
import com.goodchalk.goodpass.dailypass.controller.dto.request.DailyPassSaveRequestDto;
import com.goodchalk.goodpass.dailypass.controller.dto.response.DailyPassSaveFinishDto;
import com.goodchalk.goodpass.dailypass.controller.dto.response.DailyPassSaveFormDto;
import com.goodchalk.goodpass.dailypass.controller.dto.response.DailyPassSignatureDto;
import com.goodchalk.goodpass.dailypass.service.DailyPassSaveService;
import com.goodchalk.goodpass.dailypass.service.dto.DailyPassSaveDto;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.exception.GoodPassSystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

//아래 controller에 전체 process를 담았다.
//일일이용서 작성부터 완료까지의 process가 아래에 담겨있다.
//process 순서대로 메소드를 나열 했다.
@RestController
@RequestMapping("/daily-pass")
@RequiredArgsConstructor
public class DailyPassGuestController {
    private final DailyPassSaveService dailyPassSaveService;
    private final ClimbingGymInfoSearchService climbingGymInfoSearchService;

    @GetMapping("/new/{climbingGymId}")
    public DailyPassSaveFormDto showSaveForm(@PathVariable("climbingGymId") Long climbingGymId) {
        String climbingGymName = climbingGymInfoSearchService.findClimbingGymName(climbingGymId);
        return new DailyPassSaveFormDto(climbingGymId, climbingGymName);
    }

    //서명 작성 팝업으로 이동 해야 하는데 여기서 백엔드가 할 일?
    //조회 form과 form에 대한 저장 요청을 같은 url로 사용하여 단순화.
    //redirection 하는 url 추상화 필요. localhost와 운영 주소에 대한 추상화
    @PostMapping("/new/{climbingGymId}")
    public DailyPassSignatureDto save(@PathVariable("climbingGymId") Long climbingGymId, @RequestBody DailyPassSaveRequestDto dailyPassSaveRequestDto) {
        DailyPassSaveDto dailyPassSaveDto = dailyPassSaveRequestDto.createDailyPassSaveDto(climbingGymId);
        DailyPass dailyPass = dailyPassSaveService.save(dailyPassSaveDto);

        String redirectUrl = MessageFormat.format("https://localhost:8080/new/signature/{0}/{1}", climbingGymId, dailyPass.getId());
        Link link = Link.of(redirectUrl, "GET");
        return DailyPassSignatureDto.builder()
                .dailyPassId(dailyPass.getId())
                .redirectUrl(link)
                .climbingGymId(climbingGymId)
                .build();
    }

    //climbingGymId와 dailyPassId 둘 중 하나만 남기는 방법 고민중!
    @GetMapping("/new/signature/{climbingGymId}/{dailyPassId}/")
    public DailyPassSignatureDto showSignatureForm(@PathVariable("climbingGymId") Long climbingGymId,
                                                   @PathVariable("dailyPassId") Long dailyPassId) {
        throw new GoodPassSystemException("미구현");

//        String redirectUrl = MessageFormat.format("https://localhost:8080/completed/{0}", climbingGymId);
//        Link link = Link.of(redirectUrl, "GET");
//        return DailyPassSignatureDto.builder()
//                .climbingGymId(climbingGymId)
//                .dailyPassId(dailyPassId)
//                .redirectUrl(link)
//                .build();
    }

    @PostMapping("/new/signature/{climbingGymId}/{dailyPassId}/")
    public DailyPassSaveFinishDto saveSignature(@PathVariable("climbingGymId") Long climbingGymId) {
        throw new GoodPassSystemException("미구현");
    }

    //message 관련 로직 추가 필요
    @GetMapping("/completed/{climbingGymId}")
    public DailyPassSaveFinishDto showSaveComplete(@PathVariable("climbingGymId") Long climbingGymId) {
        String climbingGymName = climbingGymInfoSearchService.findClimbingGymName(climbingGymId);
        return new DailyPassSaveFinishDto(climbingGymName, "");
    }
}
