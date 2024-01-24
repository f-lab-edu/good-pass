package com.goodchalk.goodpass.climbinggym.domain;

import com.goodchalk.goodpass.infra.filestore.FileStore;
import com.goodchalk.goodpass.infra.filestore.GoodPassFilePath;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.nio.file.Path;

@Repository
@RequiredArgsConstructor
public class ClimbingGymPosterRepositoryImpl implements ClimbingGymPosterRepository{
    private final FileStore fileStore;

    @Override
    public String upload(ClimbingGymPoster climbingGymPoster) {
        String posterFileName = toFileName(climbingGymPoster.getClimbingGymId());
        Path targetFilePath = Path.of("climbing-gym-poster", posterFileName);
        GoodPassFilePath goodPassFilePath = GoodPassFilePath.from(targetFilePath);

        return fileStore.upload(goodPassFilePath, climbingGymPoster.getPosterInputStream());
    }

    private String toFileName(Long climbingGymId) {
        return String.format("%05d", climbingGymId);
    }
}
