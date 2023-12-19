package com.goodchalk.goodpass.service.climbinggym;

import com.goodchalk.goodpass.exception.domain.NoSuchClimbingGymException;
import com.goodchalk.goodpass.service.domain.ClimbingGym;
import com.goodchalk.goodpass.service.repository.ClimbingGymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymSearchService {
    private final ClimbingGymRepository climbingGymRepository;

    public String findClimbingGymName(Long climbingGymId) {
        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(climbingGymId);
        ClimbingGym climbingGym = climbingGymOptional.orElseThrow(NoSuchClimbingGymException::new);
        return climbingGym.getClimbingGymName();
    }
}
