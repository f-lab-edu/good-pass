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
    public void upload(ClimbingGymPoster climbingGymPoster) {
        String posterFileName = toFileName(climbingGymPoster.getClimbingGymId());
        Path targetFilePath = Path.of("climbing-gym-poster", posterFileName);
        GoodPassFilePath goodPassFilePath = GoodPassFilePath.from(targetFilePath);
        fileStore.upload(goodPassFilePath, climbingGymPoster.getPosterInputStream());
    }

    @Override
    public String findLink(Long climbingGymId) {
        return fileStore.getUrl("good-pass", "climbing-gym-poster", toFileName(climbingGymId));
    }

    private String toFileName(Long climbingGymId) {
        return String.format("%05d", climbingGymId);
    }
}
