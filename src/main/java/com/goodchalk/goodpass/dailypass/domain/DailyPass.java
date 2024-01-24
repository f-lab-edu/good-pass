package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("daily_pass")
@Getter
@NoArgsConstructor
public class DailyPass {
    @Id
    @Column("id")
    private Long id;
    @Column("climbing_gym_id")
    private Long climbingGymId;
    @Column("signature_status")
    private SignatureStatus signatureStatus;
    @Column("user_name")
    private String userName;
    @Column("contact")
    private String contact;
    @Column("daily_use_contract")
    private Contract dailyUseContract;
    @Column("privacy_contract")
    private Contract privacyContract;
    @Column("submit_datetime")
    private LocalDateTime submitDateTime;
    @Column("request_datetime")
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
