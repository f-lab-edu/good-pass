package com.goodchalk.goodpass.infra.filestore;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GoodPassFilePathTest {

    @DisplayName("파일 경로가 주어졌을 때 파일명과 부모폴더를 정상적으로 분리하는가?")
    @Test
    void from() {
        Path targetFilePath = Path.of("daily-pass", "00001.jpg");
        GoodPassFilePath goodPassFilePath = GoodPassFilePath.from(targetFilePath);

        String directoryPath = goodPassFilePath.getDirectoryPath();
        String fileName = goodPassFilePath.getFileName();

        assertThat(directoryPath).isEqualTo("daily-pass");
        assertThat(fileName).isEqualTo("00001.jpg");
    }
}