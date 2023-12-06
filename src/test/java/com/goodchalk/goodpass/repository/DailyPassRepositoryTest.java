package com.goodchalk.goodpass.repository;

import com.goodchalk.goodpass.domain.DailyPass;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DailyPassRepositoryTest {
    private final static DailyPassRepository dailyPassRepository = new MemoryDailyPassRepository();

    @BeforeEach
    public void before() {
        dailyPassRepository.clear();
    }

    @Test
    public void findByTest() {
        DailyPass dailyPass = DailyPass.builder()
                .climbingGymId(0L)
                .userName("임동규")
                .build();

        DailyPass savedDailyPass = dailyPassRepository.save(dailyPass);

        Long dailyPassId = savedDailyPass.getDailyPassId();

        DailyPass dailyPassFromRepository = dailyPassRepository.findBy(dailyPassId);

        assertThat(dailyPassFromRepository.getUserName()).isEqualTo("임동규");
        assertThat(dailyPassFromRepository.getClimbingGymId()).isEqualTo(0L);
    }

    @Test
    public void findAllTest() {
        DailyPass dailyPassInClimbingGym0 = DailyPass.builder()
                .climbingGymId(0L)
                .build();
        DailyPass dailyPassInClimbingGym1 = DailyPass.builder()
                .climbingGymId(1L)
                .build();

        dailyPassRepository.save(dailyPassInClimbingGym0);
        dailyPassRepository.save(dailyPassInClimbingGym0);
        dailyPassRepository.save(dailyPassInClimbingGym1);

        List<DailyPass> dailyPasses = dailyPassRepository.findAll(0L);

        Assertions.assertThat(dailyPasses.size()).isEqualTo(2);
    }
}