package com.goodchalk.goodpass.dailypass.domain;

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
    private SignatureStatus signatureStatus;
    private String userName;
    private String contact;
    private Contract dailyUseContract;
    private Contract privacyContract;
    private LocalDateTime submitTime;

    @Builder
    public DailyPass(Long id, Long climbingGymId, SignatureStatus signatureStatus, String userName, String contact, Contract dailyUseContract, Contract privacyContract, LocalDateTime submitTime) {
        this.id = id;
        this.climbingGymId = climbingGymId;
        this.signatureStatus = signatureStatus;
        this.userName = userName;
        this.contact = contact;
        this.dailyUseContract = dailyUseContract;
        this.privacyContract = privacyContract;
        this.submitTime = submitTime;
    }
}
