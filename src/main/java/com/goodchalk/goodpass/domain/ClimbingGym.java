package com.goodchalk.goodpass.domain;

import lombok.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Builder
public class ClimbingGym {
    private final Long climbingGymId;
    private final String climbingGymAccount;
    private final String climbingGymName;
    private final String address;
    private final String owner;
    private final String contact;
    private final String email;
}

