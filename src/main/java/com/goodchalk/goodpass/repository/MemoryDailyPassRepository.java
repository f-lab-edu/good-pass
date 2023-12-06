package com.goodchalk.goodpass.repository;

import com.goodchalk.goodpass.domain.DailyPass;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryDailyPassRepository implements DailyPassRepository{
    private static Long autoIncrease = 0L;
    private final static Map<Long, List<Long>> climbingGymDailyPassMapper = new HashMap<>();
    private final static Map<Long, DailyPass> dailyPassMapper = new HashMap<>();
    @Override
    public List<DailyPass> findAll(Long climbingGymId) {
        if (!climbingGymDailyPassMapper.containsKey(climbingGymId)) {
            return new ArrayList<>();
        }
        return climbingGymDailyPassMapper.get(climbingGymId).stream()
                .map(dailyPassMapper::get)
                .toList();
    }

    @Override
    public DailyPass findBy(Long dailyPassId) {
        if (!dailyPassMapper.containsKey(dailyPassId)) {
            throw new RuntimeException("dailyPassId = " + dailyPassId + " 존재하지 않는 dailyPass 입니다.");
        }
        return dailyPassMapper.get(dailyPassId);
    }

    @Override
    public DailyPass save(DailyPass dailyPass) {
        DailyPass newDailyPass = DailyPass.builder()
                .dailyPassId(autoIncrease++)
                .climbingGymId(dailyPass.getClimbingGymId())
                .userName(dailyPass.getUserName())
                .contact(dailyPass.getContact())
                .dailyUseContract(dailyPass.getDailyUseContract())
                .privacyContract(dailyPass.getPrivacyContract())
                .submitTime(dailyPass.getSubmitTime())
                .build();

        Long dailyPassId = newDailyPass.getDailyPassId();
        if (dailyPassMapper.containsKey(dailyPassId)) {
            throw new RuntimeException("dailyPassId = " + dailyPassId + " 이미 존재하고 있는 id값 입니다.");
        }

        Long climbingGymId = dailyPass.getClimbingGymId();
        if (climbingGymId == null) {
            throw new RuntimeException("ClimbingGymId가 필수로 포함되어야 합니다.");
        }

        if (!climbingGymDailyPassMapper.containsKey(climbingGymId)) {
            climbingGymDailyPassMapper.put(climbingGymId, new ArrayList<>());
        }

        climbingGymDailyPassMapper.get(climbingGymId).add(dailyPassId);
        dailyPassMapper.put(dailyPassId, dailyPass);

        return newDailyPass;
    }

    @Override
    public void clear() {
        climbingGymDailyPassMapper.clear();
        dailyPassMapper.clear();
    }
}
