package com.goodchalk.goodpass.repository;

import com.goodchalk.goodpass.domain.ClimbingGym;

public interface ClimbingGymRepository {
    void add(ClimbingGym climbingGym);

    ClimbingGym findBy(Long climbingGymId);

    boolean contain(Long climbingGymId);

    void clear();
}
