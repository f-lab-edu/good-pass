package com.goodchalk.goodpass.service.repository;

import com.goodchalk.goodpass.service.domain.ClimbingGym;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClimbingGymRepository extends CrudRepository<ClimbingGym, Long> {
    Optional<ClimbingGym> findByClimbingGymName(String climbingGymName);
}
