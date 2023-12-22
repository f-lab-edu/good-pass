package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.TestConfig;
import com.goodchalk.goodpass.domain.model.ClimbingGym;
import com.goodchalk.goodpass.domain.repository.ClimbingGymRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestConfig.class)
class ClimbingGymInfoSearchServiceTest {
    @Autowired
    private ClimbingGymInfoSearchService climbingGymInfoSearchService;
    @Autowired
    private ClimbingGymRepository climbingGymRepository;

    @BeforeEach
    public void beforeEach() {
        climbingGymRepository.deleteAll();
    }

    @Test
    void findClimbingGymName() {
        ClimbingGym climbingGym = ClimbingGym.builder()
                .climbingGymName("그래비티 클라이밍")
                .build();

        ClimbingGym savedClimbingGym = climbingGymRepository.save(climbingGym);
        String climbingGymName = climbingGymInfoSearchService.findClimbingGymName(savedClimbingGym.getId());

        Assertions.assertThat(climbingGymName).isEqualTo("그래비티 클라이밍");
    }

    @Test
    void findClimbingGymNameFail() {
        assertThrows(GoodPassBusinessException.class,
                () -> climbingGymInfoSearchService.findClimbingGymName(1L));
    }
}