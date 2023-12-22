package com.goodchalk.goodpass;

import com.goodchalk.goodpass.climbinggym.service.ClimbingGymInfoSearchService;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymSaveService;
import com.goodchalk.goodpass.dailypass.service.DailyPassSaveService;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import com.goodchalk.goodpass.domain.repository.stub.ClimbingGymMemoryRepository;
import com.goodchalk.goodpass.domain.repository.stub.DailyPassMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//아래 configuration 파일을 service가 추가될 때마다 추가하는 게 쉽지 않습니다.
//수동빈과 자동빈에서 수동빈이 우선권을 가지는 것으로 알고 있습니다.
//바꾸고 싶은 빈은 repository만 있으면 되기 때문에 repository만 수동빈으로 등록하여 사용하려고 합니다.
//그래서 테스트 configuration등록할 때 아래와 같이 수행합니다.
//@SpringBootTest(classes = {TestConfig.class, GoodpassApplication.class})
//service들을 수동빈 등록에서 지우고 실행하면 운영에 사용할 repository까지 읽어와서 실행이 안 됩니다
//어떻게 해결할 수 있을까요?
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