package goodchalk.goodpass.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class DailyPass {
    private Long climbingGymId;
    private Long dailyPassId;
    private String userName;
    private String contact;
    private String dailyUseContract;
    private String privacyContract;
    private String submitTime;
    private String userSignature;
}
