package com.goodchalk.goodpass.service.climbinggym;

import com.goodchalk.goodpass.exception.NoSuchClimbingGymException;
import com.goodchalk.goodpass.service.domain.ClimbingGym;
import com.goodchalk.goodpass.service.repository.ClimbingGymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymValidateService {
    private final ClimbingGymRepository climbingGymRepository;

    public void exist(Long climbingGymId) {
        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(climbingGymId);
        if (climbingGymOptional.isEmpty()) {
            throw new NoSuchClimbingGymException();
        }
    }
}
