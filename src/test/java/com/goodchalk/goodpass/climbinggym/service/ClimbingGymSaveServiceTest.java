package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.climbinggym.domain.stub.ClimbingGymMemoryRepository;
import com.goodchalk.goodpass.climbinggym.service.dto.ClimbingGymCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ClimbingGymSaveServiceTest {
    private final ClimbingGymRepository climbingGymRepository = new ClimbingGymMemoryRepository();
    private final ClimbingGymSaveService climbingGymSaveService = new ClimbingGymSaveService(climbingGymRepository);

    @DisplayName("클라이밍장을 등록했을 때 등록된 클라이밍장이 정상적으로 조회되는가?")
    @Test
    void register() {
        ClimbingGymCreator climbingGymCreator = ClimbingGymCreator.builder()
                .climbingGymName("그래비티 클라이밍")
                .build();
        ClimbingGym registeredClimbingGym = climbingGymSaveService.register(climbingGymCreator);
        Long id = registeredClimbingGym.getId();
        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(id);
        ClimbingGym climbingGym = climbingGymOptional.orElseThrow(RuntimeException::new);

        assertThat(climbingGym.getClimbingGymName()).isEqualTo("그래비티 클라이밍");
    }
}