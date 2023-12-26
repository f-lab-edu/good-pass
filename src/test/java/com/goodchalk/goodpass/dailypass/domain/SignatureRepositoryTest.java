package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.dailypass.domain.stub.SignatureStubRepository;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class SignatureRepositoryTest {
    private final SignatureRepository signatureRepository = new SignatureStubRepository();
    @Test
    void upload() {
        byte[] newImage = new byte[100];
        ByteArrayInputStream newImageInputStream = new ByteArrayInputStream(newImage);
        signatureRepository.upload(new Signature(1L, newImageInputStream));
    }
}