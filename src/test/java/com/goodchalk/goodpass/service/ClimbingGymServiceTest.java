package com.goodchalk.goodpass.service;

import com.goodchalk.goodpass.domain.ClimbingGym;
import com.goodchalk.goodpass.repository.ClimbingGymRepository;
import com.goodchalk.goodpass.repository.DailyPassRepository;
import com.goodchalk.goodpass.repository.MemoryClimbingGymRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingGymServiceTest {
    public static final ClimbingGymRepository climbingGymRepository = new MemoryClimbingGymRepository();
    private static final ClimbingGymService climbingGymService = new ClimbingGymService(climbingGymRepository);
    @Test
    void findClimbingGymName() {
        ClimbingGym climbingGym = new ClimbingGym(0L, "", "test.climbing", "", "", "", "");
        climbingGymService.save(climbingGym);

        String climbingGymName = climbingGymService.findClimbingGymName(0L);

        Assertions.assertThat(climbingGymName).isEqualTo("test.climbing");
    }
}