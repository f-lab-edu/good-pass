package com.goodchalk.goodpass.domain.repository;

import com.goodchalk.goodpass.domain.model.DailyPass;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DailyPassJdbcRepository extends CrudRepository<DailyPass, Long> {
    Optional<DailyPass> findByUserName(String userName);

    List<DailyPass> findByClimbingGymId(Long climbingGymId);
}
