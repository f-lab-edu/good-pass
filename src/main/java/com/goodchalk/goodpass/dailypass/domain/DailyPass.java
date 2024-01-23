package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("DAILY_PASS")
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
    private LocalDateTime submitDateTime;
    private LocalDateTime requestDateTime;

    @Builder
    public DailyPass(Long id, Long climbingGymId, SignatureStatus signatureStatus, String userName, String contact, Contract dailyUseContract, Contract privacyContract, LocalDateTime submitDateTime, LocalDateTime requestDateTime) {
        this.id = id;
        this.climbingGymId = climbingGymId;
        this.signatureStatus = signatureStatus;
        this.userName = userName;
        this.contact = contact;
        this.dailyUseContract = dailyUseContract;
        this.privacyContract = privacyContract;
        this.submitDateTime = submitDateTime;
        this.requestDateTime = requestDateTime;
    }

    public void updateSignatureSubmitted() {
        if (signatureStatus == SignatureStatus.SUBMIT) {
            throw new GoodPassBusinessException("이미 서명이 제출된 일일이용동의서입니다.");
        }
        this.signatureStatus = SignatureStatus.SUBMIT;
    }
}
