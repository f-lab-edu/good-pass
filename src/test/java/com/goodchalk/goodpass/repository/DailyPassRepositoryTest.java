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
        DailyPass dailyPass = new DailyPass(1L,1L,
                "임동규", "01087060902", "Agree", "Agree", "???");

        dailyPassRepository.add(dailyPass);
        DailyPass dailyPassFromRepository = dailyPassRepository.findBy(dailyPass.getDailyPassId());

        assertThat(dailyPass).isEqualTo(dailyPassFromRepository);
    }

    @Test
    public void findAllTest() {
        DailyPass dailyPass1 = new DailyPass(1L, 1L,
                "임동규", "01087060902", "Agree", "Agree", "???");
        DailyPass dailyPass2 = new DailyPass(2L, 1L,
                "임동규", "01087060902", "Agree", "Agree", "???");
        DailyPass dailyPass3 = new DailyPass(3L, 2L,
                "임동규", "01087060902", "Agree", "Agree", "???");

        dailyPassRepository.add(dailyPass1);
        dailyPassRepository.add(dailyPass2);
        dailyPassRepository.add(dailyPass3);

        List<DailyPass> dailyPasses = dailyPassRepository.findAll(1L);

        assertThat(dailyPasses).contains(dailyPass1);
        assertThat(dailyPasses).contains(dailyPass2);
        assertThat(dailyPasses).doesNotContain(dailyPass3);
    }
}