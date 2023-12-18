package com.goodchalk.goodpass.service.dailypass;

import com.goodchalk.goodpass.GoodpassApplication;
import com.goodchalk.goodpass.exception.NoSuchClimbingGymException;
import com.goodchalk.goodpass.service.domain.ClimbingGym;
import com.goodchalk.goodpass.service.domain.Contract;
import com.goodchalk.goodpass.service.domain.DailyPass;
import com.goodchalk.goodpass.service.dailypass.dto.DailyPassSaveDto;
import com.goodchalk.goodpass.service.repository.ClimbingGymRepository;
import com.goodchalk.goodpass.service.repository.DailyPassRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(classes = GoodpassApplication.class)
class DailyPassSaveServiceTest {
    @Autowired
    private DailyPassSaveService dailyPassSaveService;

    @Autowired
    private ClimbingGymRepository climbingGymRepository;

    @Autowired
    private DailyPassRepository dailyPassRepository;

    @BeforeEach
    void beforeEach() {
        dailyPassRepository.deleteAll();
        climbingGymRepository.deleteAll();
    }

    @Test
    void save() {
        DailyPassSaveDto dailyPassSaveDto = DailyPassSaveDto.builder()
                .userName("임동규")
                .dailyUseGymContract(Contract.Agree)
                .submitTime(LocalDateTime.now())
                .build();

        Assertions.assertThrows(NoSuchClimbingGymException.class, () -> {
            dailyPassSaveService.save(0L, dailyPassSaveDto);
        });
    }

    @Test
    void save2() {
        ClimbingGym climbingGym = climbingGymRepository.save(ClimbingGym.builder()
                .climbingGymName("그래비티클라이밍")
                .build());

        Long climbingGymId = climbingGym.getId();

        DailyPassSaveDto dailyPassSaveDto = DailyPassSaveDto.builder()
                .userName("임동규")
                .dailyUseGymContract(Contract.Agree)
                .submitTime(LocalDateTime.now())
                .build();

        dailyPassSaveService.save(climbingGymId, dailyPassSaveDto);

        DailyPass dailyPass = dailyPassRepository.findByUserName("임동규");

        assertThat(dailyPass.getUserName()).isEqualTo("임동규");
    }
}