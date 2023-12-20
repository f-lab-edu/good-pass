package com.goodchalk.goodpass.domain.repository;

import com.goodchalk.goodpass.domain.model.ClimbingGym;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class ClimbingGymMemoryRepository implements ClimbingGymRepository {
    private final static int AUTO_INCREMENT = 0;
    private final Map<Long, ClimbingGym> climbingGymHashMap = new HashMap<>();

    @Override
    public Optional<ClimbingGym> findByClimbingGymName(String climbingGymName) {
        return climbingGymHashMap.values().stream()
                .filter(climbingGym -> climbingGym.getClimbingGymName().equals(climbingGymName))
                .findFirst();
    }

    @Override
    public ClimbingGym save(ClimbingGym climbingGym) {
        return ClimbingGym.builder()
                .climbingGymName(climbingGym.getClimbingGymName())
                .address(climbingGym.getAddress())
                .owner(climbingGym.getOwner())
                .email(climbingGym.getEmail())
                .contact(climbingGym.getContact())
                .build();
    }

    @Override
    public Optional<ClimbingGym> findById(Long climbingGymId) {
        return Optional.of(climbingGymHashMap.get(climbingGymId));
    }

    @Override
    public void deleteAll() {
        climbingGymHashMap.clear();
    }

    @Override
    public Iterable<ClimbingGym> findAll() {
        return climbingGymHashMap.values();
    }
}
