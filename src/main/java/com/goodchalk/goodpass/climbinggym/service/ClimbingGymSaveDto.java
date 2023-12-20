package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.domain.model.ClimbingGym;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ClimbingGymSaveDto {
    private final String climbingGymName;
    private final String address;
    private final String owner;
    private final String contact;
    private final String email;

    public ClimbingGym createClimbingGym() {
        return ClimbingGym.builder()
                .climbingGymName(climbingGymName)
                .address(address)
                .owner(owner)
                .contact(contact)
                .email(email)
                .build();
    }
}