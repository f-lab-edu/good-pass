package goodchalk.goodpass.repository;

import goodchalk.goodpass.dto.DailyPass;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyPassRepository {
    List<DailyPass> findAll(Long climbingGymId);
    Long findBy(Long dailyPassId);
    Long findDailyPassIdByContact(String contact);
    Long findDailyPassIdByUserName(String userName);
    void delete(Long dailyPassId);
    void save(DailyPass dailyPass);
}
