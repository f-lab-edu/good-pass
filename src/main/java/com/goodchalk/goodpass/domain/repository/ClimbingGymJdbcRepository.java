package com.goodchalk.goodpass.domain.repository;

import com.goodchalk.goodpass.domain.model.ClimbingGym;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClimbingGymJdbcRepository extends CrudRepository<ClimbingGym, Long> {
    Optional<ClimbingGym> findByClimbingGymName(String climbingGymName);

    Iterable<ClimbingGym> findAll();
}
