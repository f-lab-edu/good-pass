package com.goodchalk.goodpass.climbinggym.domain;

import java.io.InputStream;

public interface ClimbingGymContentRepository {
    InputStream findById(Long climbingGymId);

    void upload(ClimbingGymContentPoster climbingGymContentPoster);
}
