package com.goodchalk.goodpass.domain.repository;

import com.goodchalk.goodpass.domain.model.DailyPass;
import lombok.RequiredArgsConstructor;
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
}
