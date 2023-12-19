package com.goodchalk.goodpass.springjdbc;

import com.goodchalk.goodpass.GoodpassApplication;
import com.goodchalk.goodpass.service.domain.ClimbingGym;
import com.goodchalk.goodpass.service.domain.Contract;
import com.goodchalk.goodpass.service.domain.DailyPass;
import com.goodchalk.goodpass.service.repository.ClimbingGymRepository;
import com.goodchalk.goodpass.service.repository.DailyPassRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest(classes = GoodpassApplication.class)
public class SpringBasicJdbcTest {
    @Autowired
    private ClimbingGymRepository climbingGymRepository;
    @Autowired
    private DailyPassRepository dailyPassRepository;

    @Test
    public void test1() {
        System.out.println(climbingGymRepository);
    }

    @Test
    public void test2() {
        System.out.println(climbingGymRepository.findAll());
    }

    @Test
    public void test3() {
        ClimbingGym climbingGym = ClimbingGym.builder().climbingGymName("픽클라이밍").build();
        System.out.println(climbingGymRepository.save(climbingGym));
    }

    @Test
    public void test4() {
        DailyPass dailyPass = DailyPass.builder().userName("임동규").build();
        dailyPassRepository.save(dailyPass);
    }

    @Test
    public void testDateTimeType1() {
        DailyPass dailyPass = DailyPass.builder().userName("dateTimeTest").submitTime(LocalDateTime.now()).build();

        dailyPassRepository.save(dailyPass);
    }

    @Test
    public void testDateTimeType2() {
        DailyPass dailyPass = DailyPass.builder().userName("dateTimeTest2").submitTime(LocalDateTime.now()).build();
        dailyPassRepository.save(dailyPass);

        Optional<DailyPass> dailyPass1 = dailyPassRepository.findById(1L);
        DailyPass dailyPass2 = dailyPass1.orElse(null);
    }

    @Test
    public void testEnumType1() {
        DailyPass dailyPass = DailyPass.builder().userName("enumTest").privacyContract(Contract.AGREE).build();
        dailyPassRepository.save(dailyPass);
    }

    @Test
    public void testEnumType2() {
        DailyPass dailyPass = DailyPass.builder().userName("enumTest2")
                .privacyContract(Contract.AGREE)
                .dailyUseContract(Contract.DISAGREE).build();
        dailyPassRepository.save(dailyPass);
    }
}
