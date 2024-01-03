package com.goodchalk.goodpass.dailypass.domain.stub;

import com.goodchalk.goodpass.dailypass.domain.Signature;
import com.goodchalk.goodpass.dailypass.domain.SignatureRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import com.goodchalk.goodpass.exception.GoodPassSystemException;
import lombok.RequiredArgsConstructor;

import java.io.*;

@RequiredArgsConstructor
public class SignatureStubRepository implements SignatureRepository {
    private final FileStore fileStore;

    @Override
    public void upload(Signature signature) {
        InputStream signatureInputStream = signature.getSignatureInputStream();
        String signatureFileName = String.format("%10d", signature.getSignatureId());
        fileStore.upload("src/test/resources", signatureFileName, signatureInputStream);
    }
}
