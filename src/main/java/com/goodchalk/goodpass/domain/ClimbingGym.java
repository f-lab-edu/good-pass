package com.goodchalk.goodpass.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class ClimbingGym {
    private Long climbingGymId;
    private String climbingGymAccount;
    private String climbingGymName;
    private String address;
    private String owner;
    private String contact;
    private String email;
    private LocalDateTime submitTime;
}
