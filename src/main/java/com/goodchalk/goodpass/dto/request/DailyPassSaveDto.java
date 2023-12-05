package com.goodchalk.goodpass.dto.request;

import lombok.Data;

@Data
public class DailyPassSaveDto {
    private String userName;
    private String contact;
    private String dailyUseGymContract;
    private String privacyContract;
    private String submitTime;
}