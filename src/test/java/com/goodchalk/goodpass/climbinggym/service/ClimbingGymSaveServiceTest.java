package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.climbinggym.service.dto.ClimbingGymCreator;
import com.goodchalk.goodpass.domain.repository.stub.ClimbingGymMemoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class ClimbingGymSaveServiceTest {
    private final ClimbingGymRepository climbingGymRepository = new ClimbingGymMemoryRepository();
    private final ClimbingGymSaveService climbingGymSaveService = new ClimbingGymSaveService(climbingGymRepository);

    @DisplayName("클라이밍장 등록이 서비스가 정상적으로 수행되는가?")
    @Test
    void register() {
        ClimbingGymCreator climbingGymCreator = ClimbingGymCreator.builder()
                .climbingGymName("그래비티 클라이밍")
                .build();
        ClimbingGym registeredClimbingGym = climbingGymSaveService.register(climbingGymCreator);
        Long id = registeredClimbingGym.getId();
        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(id);
        ClimbingGym climbingGym = climbingGymOptional.orElseThrow(RuntimeException::new);

        Assertions.assertThat(climbingGym.getClimbingGymName()).isEqualTo("그래비티 클라이밍");
    }
}