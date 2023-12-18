package com.goodchalk.goodpass.service.climbinggym;

import com.goodchalk.goodpass.exception.AlreadyRegisteredClimbingGymException;
import com.goodchalk.goodpass.service.climbinggym.dto.ClimbingGymSaveDto;
import com.goodchalk.goodpass.service.domain.ClimbingGym;
import com.goodchalk.goodpass.service.repository.ClimbingGymRepository;
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
            throw new AlreadyRegisteredClimbingGymException();
        }

        return climbingGymRepository.save(climbingGym);
    }
}
