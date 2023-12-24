package com.goodchalk.goodpass.dailypass.domain;

public interface SignatureRepository {
    void upload(Signature signature);

    boolean exist(Long dailyPassId);
}
