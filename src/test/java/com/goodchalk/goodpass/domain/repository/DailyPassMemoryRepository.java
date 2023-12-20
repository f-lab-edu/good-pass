package com.goodchalk.goodpass.domain.repository;

import com.goodchalk.goodpass.domain.model.DailyPass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DailyPassMemoryRepository implements DailyPassRepository{
    private final Map<Long, DailyPass> dailyPassMap = new HashMap<>();

    @Override
    public Optional<DailyPass> findByUserName(String userName) {
        return dailyPassMap.values().stream()
                .filter(dailyPass -> dailyPass.getUserName().equals(userName))
                .findFirst();
    }

    @Override
    public List<DailyPass> findByClimbingGymId(Long climbingGymId) {
        return dailyPassMap.values().stream()
                .filter(dailyPass -> dailyPass.getClimbingGymId().equals(climbingGymId))
                .toList();
    }

    @Override
    public void deleteAll() {
        dailyPassMap.clear();
    }

    @Override
    public Optional<DailyPass> findById(long id) {
        return Optional.of(dailyPassMap.getOrDefault(id, null));
    }

    @Override
    public DailyPass save(DailyPass dailyPass) {
        return DailyPass.builder()
                .climbingGymId(dailyPass.getClimbingGymId())
                .userName(dailyPass.getUserName())
                .contact(dailyPass.getContact())
                .dailyUseContract(dailyPass.getDailyUseContract())
                .privacyContract(dailyPass.getPrivacyContract())
                .submitTime(dailyPass.getSubmitTime())
                .build();
    }
}
