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
        ClimbingGym climbingGym = new ClimbingGym(3L,
                "test",
                "테스트클라이밍",
                "테스트",
                "센터장",
                "000-0000-0002",
                "test.climb@gmail.com");
        climbingGymRepository.add(climbingGym);
        ClimbingGym climbingGymFromRepository = climbingGymRepository.findBy(climbingGym.getClimbingGymId());

        assertThat(climbingGymFromRepository).isEqualTo(climbingGym);
    }
}