package goodchalk.goodpass.repository;

import goodchalk.goodpass.dto.DailyPass;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MemoryDailyPassRepository implements DailyPassRepository{
    public static long incrementId = 0L;
    public static Map<Long, List<Long>> climbingGymDailyPassMapper = new HashMap<>();
    public static Map<Long, DailyPass> dailyPassMapper = new HashMap<>();
    @Override
    public List<DailyPass> findAll(Long climbingGymId) {
        return climbingGymDailyPassMapper.getOrDefault(climbingGymId, new ArrayList<>()).stream()
                .map((id)-> dailyPassMapper.get(id))
                .toList();
    }

    @Override
    public DailyPass findBy(Long dailyPassId) {
        return dailyPassMapper.get(dailyPassId);
    }

    @Override
    public void save(DailyPass dailyPass) {
        dailyPass.setDailyPassId(incrementId++);
        if (!climbingGymDailyPassMapper.containsKey(dailyPass.getClimbingGymId())) {
            climbingGymDailyPassMapper.put(dailyPass.getClimbingGymId(), new ArrayList<>());
        }
        climbingGymDailyPassMapper.get(dailyPass.getClimbingGymId()).add(dailyPass.getDailyPassId());
        dailyPassMapper.put(dailyPass.getDailyPassId(), dailyPass);
    }
}
