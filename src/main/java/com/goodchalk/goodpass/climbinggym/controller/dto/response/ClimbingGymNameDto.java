package com.goodchalk.goodpass.climbinggym.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class ClimbingGymNameDto {
    private final Long climbingGymId;
    private final String climbingGymName;
}
