package com.goodchalk.goodpass.domain.repository;

import com.goodchalk.goodpass.domain.model.ClimbingGym;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClimbingGymRepository {
    Optional<ClimbingGym> findByClimbingGymName(String climbingGymName);

    ClimbingGym save(ClimbingGym climbingGym);

    Optional<ClimbingGym> findById(Long climbingGymId);

    void deleteAll();

    Iterable<ClimbingGym> findAll();
}
