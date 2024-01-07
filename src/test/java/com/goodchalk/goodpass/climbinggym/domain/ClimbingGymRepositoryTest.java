package com.goodchalk.goodpass.climbinggym.domain;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.climbinggym.domain.stub.ClimbingGymMemoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.*;

class ClimbingGymRepositoryTest {
    private final ClimbingGymRepository climbingGymRepository = new ClimbingGymMemoryRepository();

    @BeforeEach
    void beforeEach() {
        climbingGymRepository.deleteAll();
    }


    @Test
    void saveAndFindId() {
        ClimbingGym climbingGym = ClimbingGym.builder()
                .climbingGymName("그래비티 클라이밍")
                .build();
        ClimbingGym savedClimbingGym = climbingGymRepository.save(climbingGym);
        Long id = savedClimbingGym.getId();

        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(id);
        ClimbingGym findClimbingGym = climbingGymOptional.orElseThrow(RuntimeException::new);

        assertThat(findClimbingGym.getClimbingGymName()).isEqualTo(climbingGym.getClimbingGymName());
    }

    @Test
    void findByClimbingGymName() {
        ClimbingGym climbingGym = ClimbingGym.builder()
                .climbingGymName("픽클라이밍")
                .build();
        climbingGymRepository.save(climbingGym);

        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findByClimbingGymName("픽클라이밍");
        ClimbingGym actualClimbingGym = climbingGymOptional.orElseThrow(RuntimeException::new);

        Assertions.assertThat(actualClimbingGym.getClimbingGymName()).isEqualTo("픽클라이밍");
    }

    @Test
    void findAll() {
        ClimbingGym climbingGym1 = ClimbingGym.builder()
                .climbingGymName("픽클라이밍")
                .build();
        ClimbingGym climbingGym2 = ClimbingGym.builder()
                .climbingGymName("그래비티 클라이밍")
                .build();

        climbingGymRepository.save(climbingGym1);
        climbingGymRepository.save(climbingGym2);

        Iterable<ClimbingGym> climbingGyms = climbingGymRepository.findAll();
        AtomicInteger count = new AtomicInteger();
        climbingGyms.forEach(climbingGym-> count.getAndIncrement());

        Assertions.assertThat(count.get()).isEqualTo(2);
    }
}