package com.goodchalk.goodpass.service.dailypass;

import com.goodchalk.goodpass.GoodpassApplication;
import com.goodchalk.goodpass.dailypass.service.DailyPassSaveService;
import com.goodchalk.goodpass.dailypass.service.dto.DailyPassSaveDto;
import com.goodchalk.goodpass.domain.model.ClimbingGym;
import com.goodchalk.goodpass.domain.model.Contract;
import com.goodchalk.goodpass.domain.model.DailyPass;
import com.goodchalk.goodpass.domain.repository.ClimbingGymRepository;
import com.goodchalk.goodpass.domain.repository.DailyPassRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

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
                .dailyUseGymContract(Contract.AGREE)
                .submitTime(LocalDateTime.now())
                .build();

        Assertions.assertThrows(GoodPassBusinessException.class, () -> {
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
                .dailyUseGymContract(Contract.AGREE)
                .submitTime(LocalDateTime.now())
                .build();

        dailyPassSaveService.save(climbingGymId, dailyPassSaveDto);

        Optional<DailyPass> dailyPassOptional = dailyPassRepository.findByUserName("임동규");
        DailyPass dailyPass = dailyPassOptional.orElseThrow();

        assertThat(dailyPass.getUserName()).isEqualTo("임동규");
    }
}