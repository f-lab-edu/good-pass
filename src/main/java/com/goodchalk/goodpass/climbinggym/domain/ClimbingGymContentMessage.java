package com.goodchalk.goodpass.climbinggym.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ClimbingGymContentMessage {
    private final String climbingGymName;
    private final String message;
}
