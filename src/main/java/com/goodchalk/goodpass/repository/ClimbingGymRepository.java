package com.goodchalk.goodpass.repository;

import com.goodchalk.goodpass.domain.ClimbingGym;

public interface ClimbingGymRepository {
    ClimbingGym save(ClimbingGym climbingGym);

    ClimbingGym findBy(Long climbingGymId);

    boolean contain(Long climbingGymId);

    void clear();
}
