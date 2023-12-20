package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.domain.model.ClimbingGym;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import com.goodchalk.goodpass.domain.repository.ClimbingGymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymValidateService {
    private final ClimbingGymRepository climbingGymRepository;

    public void validExist(Long climbingGymId) {
        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(climbingGymId);
        if (climbingGymOptional.isEmpty()) {
            throw new GoodPassBusinessException();
        }
    }
}
