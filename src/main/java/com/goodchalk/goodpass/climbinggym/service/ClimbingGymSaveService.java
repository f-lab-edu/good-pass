package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.service.dto.ClimbingGymSaveDto;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import com.goodchalk.goodpass.domain.model.ClimbingGym;
import com.goodchalk.goodpass.domain.repository.ClimbingGymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymSaveService {
    private final ClimbingGymRepository climbingGymRepository;

    public ClimbingGym register(ClimbingGymSaveDto climbingGymSaveDto) {
        ClimbingGym climbingGym = climbingGymSaveDto.createClimbingGym();

        String climbingGymName = climbingGym.getClimbingGymName();
        Optional<ClimbingGym> registeredClimbingGym = climbingGymRepository.findByClimbingGymName(climbingGymName);
        if (registeredClimbingGym.isPresent()) {
            throw new GoodPassBusinessException();
        }

        return climbingGymRepository.save(climbingGym);
    }
}
