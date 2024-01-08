package com.goodchalk.goodpass.climbinggym.domain;

import com.amazonaws.services.s3.AmazonS3;
import com.goodchalk.goodpass.infra.filestore.FileStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClimbingGymPosterRepositoryIntegrationTest {
    @Autowired
    private AmazonS3 amazonS3;

    @Test
    void searchUrlTest() {
        URL url = amazonS3.getUrl("good-pass", "daily-pass/000000000000123");
        System.out.println(url.toString());
    }
}