package com.goodchalk.goodpass.repository;

import com.goodchalk.goodpass.domain.ClimbingGym;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryClimbingGymRepository implements ClimbingGymRepository{
    private final static Map<Long, ClimbingGym> climbingGymMapper = new HashMap<>();
    @Override
    public void add(ClimbingGym climbingGym) {
        Long climbingGymId = climbingGym.getClimbingGymId();
        if (climbingGymMapper.containsKey(climbingGymId)) {
            throw new RuntimeException("climbingGymId = " + climbingGymId + " 가 이미 repository에 존재합니다.");
        }
        climbingGymMapper.put(climbingGymId, climbingGym);
    }
    @Override
    public ClimbingGym findBy(Long climbingGymId) {
        if (!climbingGymMapper.containsKey(climbingGymId)) {
            throw new RuntimeException("climbingGymId = " + climbingGymId + " 에 해당하는 climbingGym 객체를 찾을 수 없습니다.");
        }
        return climbingGymMapper.get(climbingGymId);
    }

    @Override
    public boolean contain(Long climbingGymId) {
        return climbingGymMapper.containsKey(climbingGymId);
    }

    @Override
    public void clear() {
        climbingGymMapper.clear();
    }
}
