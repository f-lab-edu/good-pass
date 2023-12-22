package com.goodchalk.goodpass.domain.repository.stub;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class ClimbingGymMemoryRepository implements ClimbingGymRepository {
    private Long autoIncrement = 0L;
    private final Map<Long, ClimbingGym> climbingGymHashMap = new HashMap<>();

    @Override
    public Optional<ClimbingGym> findByClimbingGymName(String climbingGymName) {
        return climbingGymHashMap.values().stream()
                .filter(climbingGym -> climbingGym.getClimbingGymName().equals(climbingGymName))
                .findFirst();
    }

    @Override
    public ClimbingGym save(ClimbingGym climbingGym) {
        Long climbingGymId = ++autoIncrement;
        ClimbingGym targetClimbingGym = ClimbingGym.builder()
                .id(climbingGymId)
                .climbingGymName(climbingGym.getClimbingGymName())
                .address(climbingGym.getAddress())
                .owner(climbingGym.getOwner())
                .email(climbingGym.getEmail())
                .contact(climbingGym.getContact())
                .build();

        if (climbingGymHashMap.containsKey(climbingGymId)) {
            throw new RuntimeException("이미 존재하는 ID 값 입니다.");
        }
        climbingGymHashMap.put(climbingGymId, targetClimbingGym);

        return targetClimbingGym;
    }

    @Override
    public Optional<ClimbingGym> findById(Long climbingGymId) {
        if (!climbingGymHashMap.containsKey(climbingGymId)) {
            return Optional.empty();
        }
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
