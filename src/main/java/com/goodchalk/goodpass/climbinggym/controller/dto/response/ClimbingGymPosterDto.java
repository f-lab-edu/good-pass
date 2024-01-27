package com.goodchalk.goodpass.climbinggym.controller.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ClimbingGymPosterDto {
    private final Long climbingGymId;
    private final String posterLink;
}
