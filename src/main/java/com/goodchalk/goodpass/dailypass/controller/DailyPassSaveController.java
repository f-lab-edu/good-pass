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

    //api는 clmbingGymId resource를 신청하는 것처럼 생겼는데, 실제로는 climbingGym에 대한 dailyPassId를 발급받는 api임
    //그래서 요청하는 resource는 climbingGym의 무엇인가로 보이지만 실제로는 dailyPass의 데이터를 받음
    //이런 경우에는 설계가 잘못된 것인지 아니면 api 기준 또는 실제 응답해주는 데이터 기준 둘 중에 어디 controller로 분류해야 하는지 잘 모르겠음.
    //api라고 한다면 climbingGym에 해당하고 응답 resource 기준으로는 dailyPass에 해당!
    @PostMapping("/{climbingGymId}")
    public DailyPassSignatureDto save(@PathVariable("climbingGymId") Long climbingGymId, @RequestBody DailyPassSaveRequestDto dailyPassSaveRequestDto) {
        //이 부분은 좋은 설계인지?
        //RequestDto가 Creator를 참조하도록 변경
        //Creator가 RequestDto를 참조하면 RequestDto가 더 자주 변경될 가능성이 있는 객체인데 domain을 생성하는 Creator가 그 영향도를 domain에게 까지 넘김
        //RequestDto가 Creator를 참조하면 RequestDto에 대한 변경은 ReqeustDto 내에서 끝나게 되어 있음
        DailyPassCreator dailyPassCreator = dailyPassSaveRequestDto.toCreator(climbingGymId);
        DailyPass dailyPass = dailyPassSaveService.save(dailyPassCreator);

        return DailyPassSignatureDto.from(dailyPass);
    }


}
