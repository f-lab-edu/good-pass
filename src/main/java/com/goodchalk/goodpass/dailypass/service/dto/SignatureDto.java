package com.goodchalk.goodpass.dailypass.service.dto;

import com.goodchalk.goodpass.dailypass.domain.Signature;
import com.goodchalk.goodpass.exception.GoodPassSystemException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Getter
public class SignatureDto {
    private final Long dailyPassId;
    private final MultipartFile signatureFile;

    public Signature toSignature() {
        try {
            return new Signature(dailyPassId, signatureFile.getInputStream());
        } catch (IOException e) {
            throw new GoodPassSystemException(e);
        }
    }
}
