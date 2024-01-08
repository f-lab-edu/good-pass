package com.goodchalk.goodpass.climbinggym.domain;

import com.goodchalk.goodpass.exception.GoodPassSystemException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
@Getter
public class ClimbingGymPoster {
    private final Long climbingGymId;
    private final InputStream posterInputStream;

    public static ClimbingGymPoster of(Long climbingGymId, MultipartFile climbingGymPosterFile) {
        try {
            return new ClimbingGymPoster(climbingGymId, climbingGymPosterFile.getInputStream());
        } catch (IOException ioException) {
            throw new GoodPassSystemException(ioException);
        }
    }
}
