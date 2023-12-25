package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;

import java.util.List;
import java.util.Optional;

public interface DailyPassRepository {
    Optional<DailyPass> findByUserName(String userName);

    List<DailyPass> findByClimbingGymId(Long climbingGymId);

    void deleteAll();

    Optional<DailyPass> findById(long l);

    DailyPass save(DailyPass dailyPass);
}
