package com.goodchalk.goodpass.domain.repository;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@SpringBootTest
class DailyPassRepositoryIntegrationTest {
    @Autowired
    private DailyPassRepository dailyPassRepository;

    @BeforeEach
    void beforeEach() {
        dailyPassRepository.deleteAll();
        dailyPassRepository.save(DailyPass.builder().climbingGymId(1L).userName("0동규").build());
        dailyPassRepository.save(DailyPass.builder().climbingGymId(1L).userName("1동규").build());
        dailyPassRepository.save(DailyPass.builder().climbingGymId(1L).userName("2동규").build());
        dailyPassRepository.save(DailyPass.builder().climbingGymId(1L).userName("3동규").build());
        dailyPassRepository.save(DailyPass.builder().climbingGymId(1L).userName("4동규").build());
        dailyPassRepository.save(DailyPass.builder().climbingGymId(1L).userName("5동규").build());
        dailyPassRepository.save(DailyPass.builder().climbingGymId(1L).userName("6동규").build());
        dailyPassRepository.save(DailyPass.builder().climbingGymId(1L).userName("7동규").build());
        dailyPassRepository.save(DailyPass.builder().climbingGymId(1L).userName("8동규").build());
        dailyPassRepository.save(DailyPass.builder().climbingGymId(1L).userName("9동규").build());
    }

    @DisplayName("climbingGymId로 dailyPass 조회시 pagination에 대한 통합 테스트")
    @Test
    void paginationTest() {
        PageRequest pageRequest = PageRequest.of(3, 2);
        Page<DailyPass> dailyPassPage = dailyPassRepository.findByClimbingGymId(1L, pageRequest);

        Assertions.assertThat(dailyPassPage.getContent().get(0).getUserName()).isEqualTo("6동규");
    }

    @DisplayName("전체 dailyPass 조회 시 pagination에 대한 통합 테스트")
    @Test
    void findAllPaginationTest() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<DailyPass> dailyPassPage = dailyPassRepository.findAll(pageRequest);

        Assertions.assertThat(dailyPassPage.getContent().get(0).getUserName()).isEqualTo("0동규");
    }
}