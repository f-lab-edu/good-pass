package com.goodchalk.goodpass.climbinggym.controller.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class ClimbingGymNameDto {
    private final Long climbingGymId;
    private final String climbingGymName;
}
