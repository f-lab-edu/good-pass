package com.goodchalk.goodpass.service.repository;

import com.goodchalk.goodpass.service.domain.DailyPass;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DailyPassRepository extends CrudRepository<DailyPass, Long> {
    DailyPass findByUserName(String userName);

    List<DailyPass> findByClimbingGymId(Long climbingGymId);
}
