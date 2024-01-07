package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.exception.GoodPassSystemException;
import com.goodchalk.goodpass.infra.filestore.FileStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;

@Repository
@RequiredArgsConstructor
public class SignatureRepositoryImpl implements SignatureRepository{
    private final FileStore fileStore;
    private final SignatureFileNameConverter signatureFileNameConverter = new SignatureFileNameConverter(15);

    @Override
    public void upload(String signatureFileName, InputStream signatureInputStream) {
        fileStore.upload("good-pass", "daily-pass", signatureFileName, signatureInputStream);

        try {
            signatureInputStream.close();
        } catch (IOException ioException) {
            throw new GoodPassSystemException(ioException);
        }
    }

    @Override
    public void upload(Signature signature) {
        String signatureFileName = signatureFileNameConverter.convert(signature);
        fileStore.upload("good-pass", "daily-pass", signatureFileName, signature.getSignatureInputStream());
    }
}
