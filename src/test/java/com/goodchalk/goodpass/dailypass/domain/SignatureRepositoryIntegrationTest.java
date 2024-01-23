package com.goodchalk.goodpass.dailypass.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class SignatureRepositoryIntegrationTest {
    @Autowired
    private SignatureRepository signatureRepository;

    @Test
    void uploadTest() {
        byte[] bytes = new byte[100];
        InputStream inputStream = new ByteArrayInputStream(bytes);
        Signature signature = new Signature(123L, inputStream);
        signatureRepository.upload(signature);
    }
}