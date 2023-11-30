package com.goodchalk.goodpass.repository;

import com.goodchalk.goodpass.domain.ClimbingGym;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryClimbingGymRepository implements ClimbingGymRepository{
    private static final Map<Long, ClimbingGym> climbingGymMapper = new HashMap<>();

    {
        ClimbingGym climbingGym = new ClimbingGym();
        climbingGym.setClimbingGymId(1L);
        climbingGym.setClimbingGymName("picclimbing");
        climbingGymMapper.put(1L, climbingGym);
    }

    @Override
    public ClimbingGym findBy(Long climbingGymId) {
        return climbingGymMapper.get(climbingGymId);
    }

    @Override
    public Long findIdBy(String climbingGymName) {
        return climbingGymMapper.entrySet().stream()
                .filter((entry) -> entry.getValue().getClimbingGymName().equals(climbingGymName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("잘못된 climbingGymName입니다."))
                .getValue()
                .getClimbingGymId();
    }
}
