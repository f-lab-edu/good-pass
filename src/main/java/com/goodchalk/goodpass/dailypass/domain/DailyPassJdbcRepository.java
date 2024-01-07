package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DailyPassJdbcRepository extends CrudRepository<DailyPass, Long> {
    Optional<DailyPass> findByUserName(String userName);
    List<DailyPass> findByClimbingGymId(Long climbingGymId);
    Page<DailyPass> findByClimbingGymId(Long climbingGymId, Pageable pageable);
    Page<DailyPass> findAll(Pageable pageable);
}
