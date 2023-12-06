package com.goodchalk.goodpass.repository;

import com.goodchalk.goodpass.domain.DailyPass;

import java.util.List;

public interface DailyPassRepository {
    List<DailyPass> findAll(Long climbingGymId);
    DailyPass findBy(Long dailyPassId);
    DailyPass save(DailyPass dailyPass);
    void clear();
}
