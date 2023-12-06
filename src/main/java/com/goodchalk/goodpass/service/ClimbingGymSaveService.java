package com.goodchalk.goodpass.service;

import com.goodchalk.goodpass.domain.ClimbingGym;
import com.goodchalk.goodpass.domain.DailyPass;
import com.goodchalk.goodpass.dto.request.DailyPassSaveDto;
import com.goodchalk.goodpass.repository.ClimbingGymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClimbingGymSaveService {
    private final ClimbingGymRepository climbingGymRepository;
    public ClimbingGym save(ClimbingGym climbingGym) {
        return climbingGymRepository.save(climbingGym);
    }
}
