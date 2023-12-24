package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.service.dto.ClimbingGymCreator;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymSaveService {
    private final ClimbingGymRepository climbingGymRepository;

    public ClimbingGym register(ClimbingGymCreator climbingGymCreator) {
        ClimbingGym climbingGym = climbingGymCreator.create();

        String climbingGymName = climbingGym.getClimbingGymName();
        Optional<ClimbingGym> registeredClimbingGym = climbingGymRepository.findByClimbingGymName(climbingGymName);
        if (registeredClimbingGym.isPresent()) {
            throw new GoodPassBusinessException("중복된 클라이밍장 이름입니다. climbingGymName="+climbingGymName);
        }

        return climbingGymRepository.save(climbingGym);
    }
}
