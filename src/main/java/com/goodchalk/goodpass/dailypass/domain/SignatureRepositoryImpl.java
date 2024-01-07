package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.infra.filestore.FileStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.InputStream;

@Repository
@RequiredArgsConstructor
public class SignatureRepositoryImpl implements SignatureRepository{
    private final FileStore fileStore;

    @Override
    public void upload(String signatureFileName, InputStream signatureInputStream) {
        fileStore.upload("good-pass", "daily-pass", signatureFileName, signatureInputStream);
    }
}
