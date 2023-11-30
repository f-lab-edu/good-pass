package com.goodchalk.goodpass.repository;

import com.goodchalk.goodpass.domain.DailyPass;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyPassRepository {
    List<DailyPass> findAll(Long climbingGymId);
    DailyPass findBy(Long dailyPassId);
    void save(DailyPass dailyPass);
}
