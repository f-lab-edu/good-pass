package com.goodchalk.goodpass.service;

import com.goodchalk.goodpass.domain.ClimbingGym;
import com.goodchalk.goodpass.repository.ClimbingGymRepository;
import com.goodchalk.goodpass.repository.MemoryClimbingGymRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ClimbingGymSearchServiceTest {
    public static final ClimbingGymRepository climbingGymRepository = new MemoryClimbingGymRepository();
    private static final ClimbingGymSearchService climbingGymSearchService = new ClimbingGymSearchService(climbingGymRepository);
    @Test
    void findClimbingGymName() {
        ClimbingGym climbingGym = ClimbingGym.builder()
                .climbingGymName("testclimbinggym")
                .build();

        ClimbingGym savedClimbingGym = climbingGymRepository.save(climbingGym);

        Long climbingGymId = savedClimbingGym.getClimbingGymId();
        String climbingGymName = climbingGymSearchService.findClimbingGymName(climbingGymId);

        Assertions.assertThat(climbingGymName).isEqualTo("testclimbinggym");
    }
}