package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.dailypass.domain.stub.FileStore;
import com.goodchalk.goodpass.dailypass.domain.stub.SignatureStubRepository;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

class SignatureRepositoryTest {
    //"user.dir"로 불러오는 거 괜찮은지?
    private final FileStore fileStore = FileStore.createBy(System.getProperty("user.dir"));
    private final SignatureRepository signatureRepository = new SignatureStubRepository(fileStore);
    @Test
    void upload() {
        byte[] newImage = new byte[100];
        ByteArrayInputStream newImageInputStream = new ByteArrayInputStream(newImage);
        signatureRepository.upload(new Signature(1L, newImageInputStream));
        //업로드 되는 것까지 확인.
        //junit으로 검증하는 방법??
    }
}