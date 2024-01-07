package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class SignatureFileNameConverter {
    private final int length;

    public String convert(Signature signature) {
        Long signatureId = signature.getSignatureId();

        if (signatureId.toString().length() > length) {
            throw new GoodPassBusinessException("파일명으로 변환 시 id를 보장하지 않습니다. decimalNumber = " + signatureId);
        }

        return String.format("%0"+length+"d", signatureId);
    }
}
