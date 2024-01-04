package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class SignatureFileNameConverter {
    private final int length;

    public String convert(Signature signature) {
        Long signatureId = signature.getSignatureId();
        String decimalNumber = String.format("%d", signatureId);

        int decimalNumberLength = decimalNumber.length();
        if (decimalNumberLength > length) {
            throw new GoodPassBusinessException("파일명으로 변환 시 id를 보장하지 않습니다. decimalNumber = " + decimalNumber);
        }

        int frontZeroLength = length - decimalNumberLength;
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, frontZeroLength).forEach(i ->stringBuilder.append('0'));

        return stringBuilder.toString() + decimalNumber;
    }
}
