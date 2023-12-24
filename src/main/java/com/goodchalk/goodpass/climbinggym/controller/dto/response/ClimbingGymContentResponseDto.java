package com.goodchalk.goodpass.climbinggym.controller.dto.response;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymContentMessage;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymContentPoster;
import lombok.Builder;
import lombok.Getter;

import java.io.InputStream;

@Builder
@Getter
public class ClimbingGymContentResponseDto {
    private Long climbingGymId;
    private String climbingGymName;
    private String message;
    private InputStream climbingGymPosterInputStream;

    public static ClimbingGymContentResponseDto of(ClimbingGymContentMessage climbingGymContentMessage, ClimbingGymContentPoster climbingGymContentPoster) {
        return ClimbingGymContentResponseDto.builder()
                .climbingGymId(climbingGymContentPoster.getClimbingGymId())
                .climbingGymName(climbingGymContentMessage.getClimbingGymName())
                .message(climbingGymContentMessage.getMessage())
                .climbingGymPosterInputStream(climbingGymContentPoster.getContentInputStream())
                .build();
    }
}
