package goodchalk.goodpass.repository;

import goodchalk.goodpass.dto.DailyPass;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryDailyPassRepository implements DailyPassRepository{
    public static long incrementId = 0L;
    public static Map<Long, DailyPass> dailyPassMapper = new HashMap<>();
    @Override
    public List<DailyPass> findAll(Long climbingGymId) {
        return null;
    }

    @Override
    public Long findBy(Long dailyPassId) {
        return null;
    }

    @Override
    public Long findDailyPassIdByContact(String contact) {
        return null;
    }

    @Override
    public Long findDailyPassIdByUserName(String userName) {
        return null;
    }

    @Override
    public void delete(Long dailyPassId) {

    }

    @Override
    public void save(DailyPass dailyPass) {
        dailyPass.setDailyPassId(incrementId++);
        dailyPassMapper.put(dailyPass.getDailyPassId(), dailyPass);
    }
}
