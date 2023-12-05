package com.goodchalk.goodpass.service;

import com.goodchalk.goodpass.domain.ClimbingGym;
import com.goodchalk.goodpass.domain.DailyPass;
import com.goodchalk.goodpass.repository.ClimbingGymRepository;
import com.goodchalk.goodpass.repository.DailyPassRepository;
import com.goodchalk.goodpass.repository.MemoryClimbingGymRepository;
import com.goodchalk.goodpass.repository.MemoryDailyPassRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class DailyPassServiceTest {
    private final static ClimbingGymRepository climbingGymRepository = new MemoryClimbingGymRepository();
    private final static DailyPassRepository dailyPassRepository = new MemoryDailyPassRepository();
    private final static DailyPassService dailyPassService = new DailyPassService(dailyPassRepository, climbingGymRepository);

    @BeforeEach
    public void before() {
        climbingGymRepository.clear();
        dailyPassRepository.clear();
    }

    @DisplayName("dailyPassId로 dailyPass를 조회할 수 있는가?")
    @Test
    void testFindBy() {
        ClimbingGym climbingGym = new ClimbingGym(0L,"", "", "", "", "", "");
        climbingGymRepository.add(climbingGym);
        DailyPass dailyPass = new DailyPass(0L, 0L, "임동규", "", "", "", "");
        dailyPassService.save(dailyPass);

        DailyPass dailyPassServiced = dailyPassService.findBy(0L);

        assertThat(dailyPassServiced).isEqualTo(dailyPass);
    }

    @DisplayName("climbingGym이 등록되어 있지 않으면 dailyPass 저장에 실패하는가")
    @Test
    void testFindByFail() {
        DailyPass dailyPass = DailyPass.create(0L, "임동규", "", "", "", "");

        assertThrows(RuntimeException.class, () -> dailyPassService.save(dailyPass));
    }

    @Test
    void testFindAll() {
        ClimbingGym climbingGym1 = new ClimbingGym(0L,"", "", "", "", "", "");
        ClimbingGym climbingGym2 = new ClimbingGym(1L,"", "", "", "", "", "");
        climbingGymRepository.add(climbingGym1);
        climbingGymRepository.add(climbingGym2);

        DailyPass dailyPass1 = new DailyPass(0L, 0L, "임동규", "", "", "", "");
        DailyPass dailyPass2 = new DailyPass(1L, 0L, "임동규", "", "", "", "");
        DailyPass dailyPass3 = new DailyPass(2L, 1L, "임동규", "", "", "", "");

        dailyPassService.save(dailyPass1);
        dailyPassService.save(dailyPass2);
        dailyPassService.save(dailyPass3);

        List<DailyPass> dailyPasses = dailyPassService.findAll(0L);

        assertThat(dailyPasses).contains(dailyPass1);
        assertThat(dailyPasses).contains(dailyPass2);
        assertThat(dailyPasses).doesNotContain(dailyPass3);
    }
}