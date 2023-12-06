package com.goodchalk.goodpass.service;

import com.goodchalk.goodpass.domain.ClimbingGym;
import com.goodchalk.goodpass.domain.DailyPass;
import com.goodchalk.goodpass.dto.request.DailyPassSaveDto;
import com.goodchalk.goodpass.repository.ClimbingGymRepository;
import com.goodchalk.goodpass.repository.DailyPassRepository;
import com.goodchalk.goodpass.repository.MemoryClimbingGymRepository;
import com.goodchalk.goodpass.repository.MemoryDailyPassRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class DailyPassSearchServiceTest {
    private final static ClimbingGymRepository climbingGymRepository = new MemoryClimbingGymRepository();
    private final static DailyPassRepository dailyPassRepository = new MemoryDailyPassRepository();
    private final static DailyPassSearchService dailyPassSearchService = new DailyPassSearchService(dailyPassRepository, climbingGymRepository);
    private final static DailyPassSaveService dailyPassSaveService = new DailyPassSaveService(dailyPassRepository, climbingGymRepository);

    @BeforeEach
    public void before() {
        climbingGymRepository.clear();
        dailyPassRepository.clear();
    }

    @DisplayName("dailyPassId로 dailyPass를 조회할 수 있는가?")
    @Test
    void testFindBy() {
        ClimbingGym climbingGym = ClimbingGym.builder().build();

        ClimbingGym newClimbingGym = climbingGymRepository.save(climbingGym);
        Long climbingGymId = newClimbingGym.getClimbingGymId();

        DailyPassSaveDto dailyPassSaveDto = DailyPassSaveDto.builder()
                .userName("임동규")
                .build();

        DailyPass savedDailyPass = dailyPassSaveService.save(climbingGymId, dailyPassSaveDto);

        Long dailyPassId = savedDailyPass.getDailyPassId();
        DailyPass dailyPassServiced = dailyPassSearchService.findBy(dailyPassId);

        assertThat(dailyPassServiced.getClimbingGymId()).isEqualTo(climbingGymId);
        assertThat(dailyPassServiced.getUserName()).isEqualTo("임동규");
    }

    @DisplayName("climbingGym이 등록되어 있지 않으면 dailyPass 저장에 실패하는가")
    @Test
    void testFindByFail() {

        DailyPassSaveDto dailyPassSaveDto = DailyPassSaveDto.builder()
                .userName("임동규")
                .build();

        assertThrows(RuntimeException.class, () -> dailyPassSaveService.save(0L, dailyPassSaveDto));
    }

    @Test
    void testFindAll() {
        ClimbingGym climbingGym1 = ClimbingGym.builder()
                .climbingGymId(0L)
                .build();
        ClimbingGym climbingGym2 = ClimbingGym.builder()
                .climbingGymId(1L)
                .build();

        climbingGymRepository.save(climbingGym1);
        climbingGymRepository.save(climbingGym2);

        DailyPassSaveDto dailyPassSaveDto = DailyPassSaveDto.builder()
                .userName("임동규")
                .build();

        dailyPassSaveService.save(0L, dailyPassSaveDto);
        dailyPassSaveService.save(0L, dailyPassSaveDto);
        dailyPassSaveService.save(0L, dailyPassSaveDto);
        dailyPassSaveService.save(1L, dailyPassSaveDto);
        dailyPassSaveService.save(1L, dailyPassSaveDto);

        List<DailyPass> dailyPasses1 = dailyPassSearchService.findAll(0L);
        List<DailyPass> dailyPasses2 = dailyPassSearchService.findAll(1L);

        assertThat(dailyPasses1.size()).isEqualTo(3);
        assertThat(dailyPasses2.size()).isEqualTo(2);
    }
}