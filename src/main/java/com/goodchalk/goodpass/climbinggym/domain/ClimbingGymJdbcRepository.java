package com.goodchalk.goodpass.climbinggym.domain;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClimbingGymJdbcRepository extends CrudRepository<ClimbingGym, Long> {
    Optional<ClimbingGym> findByClimbingGymName(String climbingGymName);

    Iterable<ClimbingGym> findAll();
}
