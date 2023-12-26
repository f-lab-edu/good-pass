package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import com.goodchalk.goodpass.dailypass.service.dto.DailyPassCreator;
import com.goodchalk.goodpass.domain.repository.stub.ClimbingGymMemoryRepository;
import com.goodchalk.goodpass.domain.repository.stub.DailyPassMemoryRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DailyPassSaveServiceTest {
    private final DailyPassRepository dailyPassRepository = new DailyPassMemoryRepository();
    private final ClimbingGymRepository climbingGymRepository = new ClimbingGymMemoryRepository();
    private final DailyPassSaveService dailyPassSaveService = new DailyPassSaveService(dailyPassRepository, climbingGymRepository);

    @BeforeEach
    void beforeEach() {
        dailyPassRepository.deleteAll();
        climbingGymRepository.deleteAll();
    }

    @DisplayName("등록되지 않은 클라이밍장에 일일이용서 등록이 불가능한가?")
    @Test
    void saveWithNotRegisteredClimbingGym() {
        DailyPassCreator dailyPassCreator = DailyPassCreator.builder()
                .climbingGymId(1L)
                .userName("임동규")
                .build();

        assertThrows(GoodPassBusinessException.class,
                () -> dailyPassSaveService.save(dailyPassCreator));
    }

    @DisplayName("등록된 클라이밍장에 일일이용서 등록이 가능한가?")
    @Test
    void saveWithRegisteredClimbingGym() {
        ClimbingGym climbingGym = ClimbingGym.builder()
                .build();

        ClimbingGym savedClimbingGym = climbingGymRepository.save(climbingGym);
        Long id = savedClimbingGym.getId();
        DailyPassCreator dailyPassCreator = DailyPassCreator.builder()
                .climbingGymId(id)
                .userName("임동규")
                .build();

        DailyPass savedDailyPass = dailyPassSaveService.save(dailyPassCreator);
        Optional<DailyPass> dailyPassOptional = dailyPassRepository.findById(savedDailyPass.getId());
        DailyPass dailyPass = dailyPassOptional.orElseThrow(RuntimeException::new);

        Assertions.assertThat(dailyPass.getUserName()).isEqualTo("임동규");
    }
}