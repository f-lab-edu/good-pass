package com.goodchalk.goodpass.climbinggym.domain;

import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.InputStream;

@Repository
@RequiredArgsConstructor
public class ClimbingGymContentRepositoryImpl implements ClimbingGymContentRepository{
    @Override
    public InputStream findById(Long climbingGymId) {
        throw new GoodPassBusinessException("미구현");
    }

    @Override
    public void upload(ClimbingGymContentPoster climbingGymContentPoster) {
        throw new GoodPassBusinessException("미구현");
    }
}
