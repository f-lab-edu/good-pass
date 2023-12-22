package com.goodchalk.goodpass;

import com.goodchalk.goodpass.climbinggym.service.ClimbingGymInfoSearchService;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymSaveService;
import com.goodchalk.goodpass.dailypass.service.DailyPassSaveService;
import com.goodchalk.goodpass.domain.repository.ClimbingGymRepository;
import com.goodchalk.goodpass.domain.repository.DailyPassRepository;
import com.goodchalk.goodpass.domain.repository.stub.ClimbingGymMemoryRepository;
import com.goodchalk.goodpass.domain.repository.stub.DailyPassMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public ClimbingGymSaveService climbingGymSaveService() {
        return new ClimbingGymSaveService(climbingGymRepository());
    }

    @Bean
    public ClimbingGymInfoSearchService climbingGymInfoSearchService() {
        return new ClimbingGymInfoSearchService(climbingGymRepository());
    }

    @Bean
    public DailyPassSaveService dailyPassSaveService() {
        return new DailyPassSaveService(dailyPassRepository(), climbingGymRepository());
    }

    @Bean
    public DailyPassRepository dailyPassRepository() {
        return new DailyPassMemoryRepository();
    }

    @Bean
    public ClimbingGymRepository climbingGymRepository() {
        return new ClimbingGymMemoryRepository();
    }
}