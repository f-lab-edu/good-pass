package com.goodchalk.goodpass.service;

import com.goodchalk.goodpass.domain.ClimbingGym;
import com.goodchalk.goodpass.domain.DailyPass;
import com.goodchalk.goodpass.repository.ClimbingGymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClimbingGymService {
    private final ClimbingGymRepository climbingGymRepository;
    public String findClimbingGymName(Long climbingGymId) {
        ClimbingGym climbingGym = climbingGymRepository.findBy(climbingGymId);
        return climbingGym.getClimbingGymName();
    }

    public void save(ClimbingGym climbingGym) {
        climbingGymRepository.add(climbingGym);
    }
}
