package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.exception.GoodPassSystemException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
@Getter
public class Signature {
    private final Long signatureId;
    private final InputStream signatureInputStream;

    public static Signature of(Long dailyPassId, MultipartFile signatureFile) {
        InputStream inputStream = null;
        try {
            inputStream = signatureFile.getInputStream();
        } catch (IOException e) {
            throw new GoodPassSystemException(e);
        }
        return new Signature(dailyPassId, inputStream);
    }
}
