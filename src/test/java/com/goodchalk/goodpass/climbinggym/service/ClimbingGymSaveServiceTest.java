package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.TestConfig;
import com.goodchalk.goodpass.climbinggym.service.dto.ClimbingGymSaveDto;
import com.goodchalk.goodpass.domain.model.ClimbingGym;
import com.goodchalk.goodpass.domain.repository.ClimbingGymRepository;
import com.goodchalk.goodpass.domain.repository.DailyPassRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest(classes = TestConfig.class)
class ClimbingGymSaveServiceTest {
    @Autowired
    private ClimbingGymSaveService climbingGymSaveService;
    @Autowired
    private DailyPassRepository dailyPassRepository;
    @Autowired
    private ClimbingGymRepository climbingGymRepository;
    @Test
    void register() {
        ClimbingGymSaveDto climbingGymSaveDto = ClimbingGymSaveDto.builder()
                .climbingGymName("그래비티 클라이밍")
                .build();
        ClimbingGym registeredClimbingGym = climbingGymSaveService.register(climbingGymSaveDto);
        Long id = registeredClimbingGym.getId();
        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(id);
        ClimbingGym climbingGym = climbingGymOptional.orElseThrow(RuntimeException::new);

        Assertions.assertThat(climbingGym.getClimbingGymName()).isEqualTo("그래비티 클라이밍");
    }
}