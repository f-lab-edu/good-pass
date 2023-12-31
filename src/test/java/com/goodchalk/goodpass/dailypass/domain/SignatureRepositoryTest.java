package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.infra.filestore.LocalFileStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class SignatureRepositoryTest {
    private final SignatureRepository signatureRepository = new SignatureRepositoryImpl(new LocalFileStore());
    @DisplayName("서명 파일 stream이 주어졌을 때 fileStore에 정상적으로 upload하는가?")
    @Test
    void upload() {
        byte[] newImage = new byte[100];
        ByteArrayInputStream newImageInputStream = new ByteArrayInputStream(newImage);

        Signature signature = new Signature(1L, newImageInputStream);

        signatureRepository.upload(signature);
    }
}