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

    @DisplayName("클라이밍장이 등록되지 않았을 때 일일이용서를 등록한다면 예외가 발생하는가?")
    @Test
    void saveWithNotRegisteredClimbingGym() {
        DailyPassCreator dailyPassCreator = DailyPassCreator.builder()
                .climbingGymId(1L)
                .userName("임동규")
                .build();

        assertThrows(GoodPassBusinessException.class,
                () -> dailyPassSaveService.save(dailyPassCreator));
    }

    @DisplayName("클라이밍장이 등록되어 있을 때 일일이용서를 등록한다면 정상처리 되는가?")
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