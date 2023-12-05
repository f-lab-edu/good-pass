package com.goodchalk.goodpass.domain;

import lombok.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class ClimbingGym {
    private static Long id = 0L;

    private final Long climbingGymId;
    private final String climbingGymAccount;
    private final String climbingGymName;
    private final String address;
    private final String owner;
    private final String contact;
    private final String email;

    public static ClimbingGym create(String climbingGymAccount, String climbingGymName, String address, String owner, String contact, String email) {
        return new ClimbingGym(id++, climbingGymAccount, climbingGymName, address, owner, contact, email);
    }
}
