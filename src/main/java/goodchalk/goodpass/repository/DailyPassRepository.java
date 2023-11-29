package goodchalk.goodpass.repository;

import goodchalk.goodpass.dto.DailyPass;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyPassRepository {
    List<DailyPass> findAll(Long climbingGymId);
    DailyPass findBy(Long dailyPassId);
    void save(DailyPass dailyPass);
}
