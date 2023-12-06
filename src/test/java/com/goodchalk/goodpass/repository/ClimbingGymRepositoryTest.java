package com.goodchalk.goodpass.repository;

import com.goodchalk.goodpass.domain.ClimbingGym;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ClimbingGymRepositoryTest {
    private final static ClimbingGymRepository climbingGymRepository = new MemoryClimbingGymRepository();
    @Test
    public void findByTest() {
        ClimbingGym climbingGym = ClimbingGym.builder()
                .climbingGymName("testclimbinggym")
                .build();

        ClimbingGym savedClimbingGym = climbingGymRepository.save(climbingGym);
        Long climbingGymId = savedClimbingGym.getClimbingGymId();

        ClimbingGym climbingGymFromRepository = climbingGymRepository.findBy(climbingGymId);

        assertThat(climbingGymFromRepository.getClimbingGymName()).isEqualTo("testclimbinggym");
    }
}