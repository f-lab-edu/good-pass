package com.goodchalk.goodpass.climbinggym.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.InputStream;

@RequiredArgsConstructor
@Getter
public class ClimbingGymContentPoster {
    private final Long climbingGymId;
    private final InputStream contentInputStream;
}