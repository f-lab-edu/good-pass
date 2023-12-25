package com.goodchalk.goodpass.domain.repository;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import com.goodchalk.goodpass.dailypass.domain.SignatureStatus;
import com.goodchalk.goodpass.domain.repository.stub.DailyPassMemoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class DailyPassRepositoryTest {
    private final DailyPassRepository dailyPassRepository = new DailyPassMemoryRepository();

    @Test
    void save() {
        DailyPass dailyPass = DailyPass.builder()
                .userName("임동규")
                .build();
        DailyPass savedDailyPass = dailyPassRepository.save(dailyPass);
        Long id = savedDailyPass.getId();

        Optional<DailyPass> dailyPassOptional = dailyPassRepository.findById(id);
        DailyPass actual = dailyPassOptional.orElseThrow(RuntimeException::new);

        Assertions.assertThat(actual.getUserName()).isEqualTo("임동규");
    }

    @Test
    void findByUserName() {
        DailyPass dailyPass = DailyPass.builder()
                .userName("임동규")
                .build();
        DailyPass savedDailyPass = dailyPassRepository.save(dailyPass);
        Long id = savedDailyPass.getId();

        Optional<DailyPass> dailyPassOptional = dailyPassRepository.findByUserName("임동규");
        DailyPass actual = dailyPassOptional.orElseThrow(RuntimeException::new);

        Assertions.assertThat(actual.getUserName()).isEqualTo("임동규");
    }

    @Test
    void findByClimbingGymId() {
        DailyPass dailyPass1 = DailyPass.builder()
                .climbingGymId(1L)
                .userName("임동규")
                .build();
        DailyPass dailyPass2 = DailyPass.builder()
                .climbingGymId(1L)
                .userName("임동규")
                .build();
        DailyPass dailyPass3 = DailyPass.builder()
                .climbingGymId(2L)
                .userName("임동규")
                .build();

        dailyPassRepository.save(dailyPass1);
        dailyPassRepository.save(dailyPass2);
        dailyPassRepository.save(dailyPass3);

        List<DailyPass> dailyPasses1 = dailyPassRepository.findByClimbingGymId(1L);
        List<DailyPass> dailyPasses2 = dailyPassRepository.findByClimbingGymId(2L);
        List<DailyPass> dailyPasses3 = dailyPassRepository.findByClimbingGymId(3L);

        Assertions.assertThat(dailyPasses1.size()).isEqualTo(2);
        Assertions.assertThat(dailyPasses2.size()).isEqualTo(1);
        Assertions.assertThat(dailyPasses3.size()).isEqualTo(0);
    }

    @Test
    void addSignatureFieldColumn() {
        DailyPass dailyPass = DailyPass.builder()
                .climbingGymId(1L)
                .userName("임동규")
                .signatureStatus(SignatureStatus.SUBMIT)
                .build();
        DailyPass savedDailyPass = dailyPassRepository.save(dailyPass);

        Optional<DailyPass> dailyPassOptional = dailyPassRepository.findById(savedDailyPass.getId());
        DailyPass actualDailyPass = dailyPassOptional.orElseThrow(RuntimeException::new);

        Assertions.assertThat(actualDailyPass.getSignatureStatus()).isEqualTo(SignatureStatus.SUBMIT);
    }
}