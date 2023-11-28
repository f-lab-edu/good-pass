package goodchalk.goodpass.repository;

import goodchalk.goodpass.dto.ClimbingGym;
import org.springframework.stereotype.Repository;

public interface ClimbingGymRepository {

    ClimbingGym findBy(Long climbingGymId);
    Long findIdBy(String climbingGymName);
}
