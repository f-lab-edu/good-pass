package com.goodchalk.goodpass.dailypass.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DailyPassRepositoryImpl implements DailyPassRepository{
    private final DailyPassJdbcRepository dailyPassJdbcRepository;

    @Override
    public DailyPass save(DailyPass dailyPass) {
        return dailyPassJdbcRepository.save(dailyPass);
    }

    @Override
    public Optional<DailyPass> findById(long id) {
        return dailyPassJdbcRepository.findById(id);
    }

    @Override
    public void deleteAll() {
        dailyPassJdbcRepository.deleteAll();
    }

    @Override
    public Optional<DailyPass> findByUserName(String userName) {
        return dailyPassJdbcRepository.findByUserName(userName);
    }

    @Override
    public List<DailyPass> findByClimbingGymId(Long climbingGymId) {
        return dailyPassJdbcRepository.findByClimbingGymId(climbingGymId);
    }

    @Override
    public Page<DailyPass> findByClimbingGymId(Long climbingGymId, Pageable pageable) {
        return dailyPassJdbcRepository.findByClimbingGymId(climbingGymId, pageable);
    }

    @Override
    public Page<DailyPass> findAll(Pageable pageable) {
        return dailyPassJdbcRepository.findAll(pageable);
    }
}
