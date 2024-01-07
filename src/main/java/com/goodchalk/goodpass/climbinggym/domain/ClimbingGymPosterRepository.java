package com.goodchalk.goodpass.climbinggym.domain;

public interface ClimbingGymPosterRepository {
    void upload(ClimbingGymPoster climbingGymPoster);

    String findLink(Long climbingGymId);
}
