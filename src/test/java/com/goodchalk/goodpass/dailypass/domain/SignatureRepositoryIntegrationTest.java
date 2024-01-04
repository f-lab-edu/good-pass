package com.goodchalk.goodpass.dailypass.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;

@SpringBootTest
class SignatureRepositoryIntegrationTest {
    @Autowired
    private SignatureRepository signatureRepository;

    @Test
    void upload() {
        System.out.println(signatureRepository);
        signatureRepository.upload(new Signature(1L, new ByteArrayInputStream(new byte[100])));
    }
}