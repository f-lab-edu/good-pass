package com.goodchalk.goodpass.repository;

import com.goodchalk.goodpass.domain.ClimbingGym;

public interface ClimbingGymRepository {
    ClimbingGym findBy(Long climbingGymId);
    Long findIdBy(String climbingGymName);
}
