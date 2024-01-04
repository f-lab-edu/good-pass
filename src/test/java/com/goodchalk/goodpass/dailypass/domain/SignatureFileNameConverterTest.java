package com.goodchalk.goodpass.dailypass.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class SignatureFileNameConverterTest {
    @DisplayName("서명 ID와 파일명 길이가 주어졌을 때 파일명으로 변환 시 빈 자리수는 0으로 채워지는가?")
    @Test
    void convert() {
        SignatureFileNameConverter signatureFileNameConverter = new SignatureFileNameConverter(10);
        Signature signature = new Signature(1234L, new ByteArrayInputStream(new byte[0]));

        String signatureFileName = signatureFileNameConverter.convert(signature);

        Assertions.assertThat(signatureFileName).isEqualTo("0000001234");
    }
}