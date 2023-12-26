package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.domain.repository.stub.ClimbingGymMemoryRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ClimbingGymInfoSearchServiceTest {
    private final ClimbingGymRepository climbingGymRepository = new ClimbingGymMemoryRepository();
    private final ClimbingGymInfoSearchService climbingGymInfoSearchService = new ClimbingGymInfoSearchService(climbingGymRepository);

    @BeforeEach
    public void beforeEach() {
        climbingGymRepository.deleteAll();
    }

    @DisplayName("클라이밍장 id가 주어졌다면 클라이밍장 상호명을 검색가능한가?")
    @Test
    void findClimbingGymName() {
        ClimbingGym climbingGym = ClimbingGym.builder()
                .climbingGymName("그래비티 클라이밍")
                .build();

        ClimbingGym savedClimbingGym = climbingGymRepository.save(climbingGym);
        String climbingGymName = climbingGymInfoSearchService.findClimbingGymName(savedClimbingGym.getId());

        Assertions.assertThat(climbingGymName).isEqualTo("그래비티 클라이밍");
    }

    @DisplayName("클라이밍장이 등록되지 않았다면 상호명을 검색할 때 예외처리가 수행되는가?")
    @Test
    void findClimbingGymNameFail() {
        assertThrows(GoodPassBusinessException.class,
                () -> climbingGymInfoSearchService.findClimbingGymName(1L));
    }
}