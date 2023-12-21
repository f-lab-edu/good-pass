package com.goodchalk.goodpass.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("daily_pass")
@Getter
@NoArgsConstructor
public class DailyPass {
    @Id
    private Long id;
    private Long climbingGymId;
    private String userName;
    private String contact;
    private Contract dailyUseContract;
    private Contract privacyContract;
    private LocalDateTime submitTime;

    @Builder
    public DailyPass(Long id, Long climbingGymId, String userName, String contact, Contract dailyUseContract, Contract privacyContract, LocalDateTime submitTime) {
        this.id = id;
        this.climbingGymId = climbingGymId;
        this.userName = userName;
        this.contact = contact;
        this.dailyUseContract = dailyUseContract;
        this.privacyContract = privacyContract;
        this.submitTime = submitTime;
    }
}
