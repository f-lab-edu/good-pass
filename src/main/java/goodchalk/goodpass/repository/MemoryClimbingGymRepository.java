package goodchalk.goodpass.repository;

import goodchalk.goodpass.dto.ClimbingGym;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryClimbingGymRepository implements ClimbingGymRepository{

    @Override
    public ClimbingGym findBy(Long climbingGymId) {
        return null;
    }

    @Override
    public Long findIdBy(String climbingGymName) {
        return null;
    }
}
