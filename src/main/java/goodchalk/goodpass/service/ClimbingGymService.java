package goodchalk.goodpass.service;

import goodchalk.goodpass.repository.ClimbingGymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClimbingGymService {
    private final ClimbingGymRepository climbingGymRepository;
    public Long findIdBy(String climbingGymAccount) {
        return climbingGymRepository.findIdBy(climbingGymAccount);
    }
}
