package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.TestConfig;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("클라이밍장ID를 통해 클라이밍장 이름 검색이 제대로 수행되는가?")
    @Test
    void findClimbingGymName() {
        ClimbingGym climbingGym = ClimbingGym.builder()
                .climbingGymName("그래비티 클라이밍")
                .build();

        ClimbingGym savedClimbingGym = climbingGymRepository.save(climbingGym);
        String climbingGymName = climbingGymInfoSearchService.findClimbingGymName(savedClimbingGym.getId());

        Assertions.assertThat(climbingGymName).isEqualTo("그래비티 클라이밍");
    }

    @DisplayName("등로된 클라이밍장이 아닐 때 예외처리가 수행되는가?")
    @Test
    void findClimbingGymNameFail() {
        assertThrows(GoodPassBusinessException.class,
                () -> climbingGymInfoSearchService.findClimbingGymName(1L));
    }
}