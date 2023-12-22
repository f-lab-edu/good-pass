package com.goodchalk.goodpass.climbinggym.domain;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;

import java.util.Optional;

public interface ClimbingGymRepository {
    Optional<ClimbingGym> findByClimbingGymName(String climbingGymName);

    ClimbingGym save(ClimbingGym climbingGym);

    Optional<ClimbingGym> findById(Long climbingGymId);

    void deleteAll();

    Iterable<ClimbingGym> findAll();
}
