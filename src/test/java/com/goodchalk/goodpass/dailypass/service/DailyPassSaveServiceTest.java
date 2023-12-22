package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.GoodpassApplication;
import com.goodchalk.goodpass.TestConfig;
import com.goodchalk.goodpass.dailypass.service.dto.DailyPassSaveDto;
import com.goodchalk.goodpass.domain.model.ClimbingGym;
import com.goodchalk.goodpass.domain.model.DailyPass;
import com.goodchalk.goodpass.domain.repository.ClimbingGymRepository;
import com.goodchalk.goodpass.domain.repository.DailyPassRepository;
import com.goodchalk.goodpass.domain.repository.stub.ClimbingGymMemoryRepository;
import com.goodchalk.goodpass.domain.repository.stub.DailyPassMemoryRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = TestConfig.class)
class DailyPassSaveServiceTest {
    @Autowired
    private DailyPassSaveService dailyPassSaveService;
    @Autowired
    private DailyPassRepository dailyPassRepository;
    @Autowired
    private ClimbingGymRepository climbingGymRepository;

    @BeforeEach
    void beforeEach() {
        dailyPassRepository.deleteAll();
        climbingGymRepository.deleteAll();
    }

    @Test
    void saveWithNotRegisteredClimbingGym() {
        DailyPassSaveDto dailyPassSaveDto = DailyPassSaveDto.builder()
                .climbingGymId(1L)
                .userName("임동규")
                .build();

        assertThrows(GoodPassBusinessException.class,
                () -> dailyPassSaveService.save(dailyPassSaveDto));
    }

    @Test
    void saveWithRegisteredClimbingGym() {
        ClimbingGym climbingGym = ClimbingGym.builder()
                .build();

        ClimbingGym savedClimbingGym = climbingGymRepository.save(climbingGym);
        Long id = savedClimbingGym.getId();
        DailyPassSaveDto dailyPassSaveDto = DailyPassSaveDto.builder()
                .climbingGymId(id)
                .userName("임동규")
                .build();

        DailyPass savedDailyPass = dailyPassSaveService.save(dailyPassSaveDto);
        Optional<DailyPass> dailyPassOptional = dailyPassRepository.findById(savedDailyPass.getId());
        DailyPass dailyPass = dailyPassOptional.orElseThrow(RuntimeException::new);

        Assertions.assertThat(dailyPass.getUserName()).isEqualTo("임동규");
    }
}