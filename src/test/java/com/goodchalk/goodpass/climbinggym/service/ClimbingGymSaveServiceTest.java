package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.climbinggym.service.dto.ClimbingGymCreator;
import com.goodchalk.goodpass.climbinggym.domain.stub.ClimbingGymMemoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class ClimbingGymSaveServiceTest {
    private final ClimbingGymRepository climbingGymRepository = new ClimbingGymMemoryRepository();
    private final ClimbingGymSaveService climbingGymSaveService = new ClimbingGymSaveService(climbingGymRepository);

    //아래 코드 같은 경우네는 given when then이 분명하지 하지 않은데 이럴 때 어떻게 해야하는가?
    //저장이 정상적으로 수행되었는지를 체크하려면 조회에 대한 기능을 같이 검증해야 한다...
    //기능 검증이 완전히 분리가 안 되고 있다.
    @DisplayName("클라이밍장을 등록했을 때 등록된 클라이밍장이 정상적으로 조회되는가?")
    @Test
    void register() {
        ClimbingGymCreator climbingGymCreator = ClimbingGymCreator.builder()
                .climbingGymName("그래비티 클라이밍")
                .build();
        ClimbingGym registeredClimbingGym = climbingGymSaveService.register(climbingGymCreator);
        Long id = registeredClimbingGym.getId();
        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(id);
        ClimbingGym climbingGym = climbingGymOptional.orElseThrow(RuntimeException::new);

        Assertions.assertThat(climbingGym.getClimbingGymName()).isEqualTo("그래비티 클라이밍");
    }
}