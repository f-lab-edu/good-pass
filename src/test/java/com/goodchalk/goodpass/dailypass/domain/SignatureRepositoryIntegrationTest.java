package com.goodchalk.goodpass.dailypass.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SignatureRepositoryIntegrationTest {
    @Autowired
    private SignatureRepository signatureRepository;
    private final SignatureFileNameConverter signatureFileNameConverter = new SignatureFileNameConverter(15);

    @Test
    public void uploadTest() {
        byte[] bytes = new byte[100];
        InputStream inputStream = new ByteArrayInputStream(bytes);
        String signatureFileName = signatureFileNameConverter.convert(new Signature(123L, inputStream));
        signatureRepository.upload(signatureFileName, inputStream);
    }
}