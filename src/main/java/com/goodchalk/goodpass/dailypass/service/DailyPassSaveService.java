package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.SignatureStatus;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import com.goodchalk.goodpass.dailypass.service.dto.DailyPassCreator;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyPassSaveService {
    private final DailyPassRepository dailyPassRepository;
    private final ClimbingGymRepository climbingGymRepository;

    //DailyPassSaveRequestDto -> DailyPassSaveDto <- DailyPassSaveService -> DailyPass
    //creatNoSignatureDailyPass() 비지니스 로직이 담긴 메소드입니다.
    //이를 처음에는 DailyPassSaveDto에 넣다가 비지니스 로직이 Dto에 들어가 있는 게 이상해서 dailyPass로 뺐습니다.
    //DailyPass가 그러면 dailyPassSaveDto를 알고 있어야 하더라구요. dailyPassSaveDto는 외부에 제공하는 값이라 dailyPass가 알고 있는게 이상합니다
    //그래서 dailyPass에 넣지 않고 Service 단계에서 creatNoSignatureDailyPass()를 두었습니다.
    public DailyPass save(DailyPassCreator dailyPassCreator) {
        Long climbingGymId = dailyPassCreator.getClimbingGymId();

        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(climbingGymId);
        climbingGymOptional.orElseThrow(()->new GoodPassBusinessException("등록된 클라이밍장이 없습니다. id="+climbingGymId));

        DailyPass noSignatureDailyPass = dailyPassCreator.createNoSignatureDailyPass();

        return dailyPassRepository.save(noSignatureDailyPass);
    }
}
