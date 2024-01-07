package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DailyPassRepository {
    Optional<DailyPass> findByUserName(String userName);

    List<DailyPass> findByClimbingGymId(Long climbingGymId);

    void deleteAll();

    Optional<DailyPass> findById(long l);

    DailyPass save(DailyPass dailyPass);

    Page<DailyPass> findByClimbingGymId(Long climbingGymId, Pageable pageable);
    Page<DailyPass> findAll(Pageable pageable);
}
