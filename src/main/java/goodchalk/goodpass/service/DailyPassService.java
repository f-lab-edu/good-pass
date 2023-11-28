package goodchalk.goodpass.service;

import goodchalk.goodpass.dto.ClimbingGym;
import goodchalk.goodpass.dto.DailyPass;
import goodchalk.goodpass.repository.ClimbingGymRepository;
import goodchalk.goodpass.repository.DailyPassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DailyPassService {
    public static final List<DailyPass> EMPTY_LIST_DAIL_PASS = new ArrayList<>();

    private final DailyPassRepository dailyPassRepository;
    private final ClimbingGymRepository climbingGymRepository;

    public List<DailyPass> findAllBy(String climbingGymName) {
        Long climbingGymId = climbingGymRepository.findIdBy(climbingGymName);
        if (climbingGymId == null) {
            return EMPTY_LIST_DAIL_PASS;
        }
        return dailyPassRepository.findAll(climbingGymId);
    }

    public void save(DailyPass dailyPass) {
        Long targetClimbingGymId = dailyPass.getClimbingGymId();
        ClimbingGym climbingGym = climbingGymRepository.findBy(targetClimbingGymId);
        if (climbingGym == null) {
            throw new RuntimeException("존재하지 않는 id값 입니다. climbingGymName = " + targetClimbingGymId);
        }
        dailyPassRepository.save(dailyPass);
    }
}

