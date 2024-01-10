package com.goodchalk.goodpass.infra.filestore;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.nio.file.Path;

@RequiredArgsConstructor
@Getter
public class GoodPassFilePath {
    private final String fileName;
    private final String directoryPath;

    public static GoodPassFilePath from(Path path) {
        String fileName = path.getFileName().toString();
        String directoryPath = path.getParent().toString();
        return new GoodPassFilePath(fileName, directoryPath);
    }
}
