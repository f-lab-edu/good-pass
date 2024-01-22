package com.goodchalk.goodpass.dailypass.domain;

import java.io.InputStream;

public interface SignatureRepository {
    void upload(String signatureFileName, InputStream signatureInputStream);

    void upload(Signature signature);
}
