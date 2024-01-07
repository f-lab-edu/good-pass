package com.goodchalk.goodpass.climbinggym.domain;

import com.goodchalk.goodpass.infra.filestore.FileStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ClimbingGymPosterRepositoryImpl implements ClimbingGymPosterRepository{
    private final FileStore fileStore;

    @Override
    public void upload(ClimbingGymPoster climbingGymPoster) {
        Long climbingGymId = climbingGymPoster.getClimbingGymId();
        String posterFileName = toFileName(climbingGymId);
        fileStore.upload("good-pass",
                "climbing-gym-poster",
                posterFileName,
                climbingGymPoster.getPosterInputStream());
    }

    @Override
    public String findLink(Long climbingGymId) {
        return fileStore.getUrl("good-pass", "climbing-gym-poster", toFileName(climbingGymId));
    }

    private String toFileName(Long climbingGymId) {
        return String.format("%05d", climbingGymId);
    }
}
