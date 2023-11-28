package goodchalk.goodpass.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class ClimbingGym {
    private final Long climbingGymId;
    private final String climbingGymName;
    private final String address;
    private final String owner;
    private final String contact;
    private final String email;
    private final LocalDateTime submitTime;
}
