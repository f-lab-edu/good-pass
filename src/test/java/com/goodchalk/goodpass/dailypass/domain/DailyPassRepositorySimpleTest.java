package com.goodchalk.goodpass.dailypass.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("dev")
public class DailyPassRepositorySimpleTest {
    @Autowired
    private DailyPassRepository dailyPassRepository;
    @Test
    void test() {
        Optional<DailyPass> dailyPassOptional = dailyPassRepository.findById(0L);
    }
}
