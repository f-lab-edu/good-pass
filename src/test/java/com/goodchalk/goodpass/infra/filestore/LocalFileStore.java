package com.goodchalk.goodpass.infra.filestore;

import com.goodchalk.goodpass.exception.GoodPassSystemException;
import com.goodchalk.goodpass.infra.filestore.FileStore;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class LocalFileStore implements FileStore {
    private final String basePath = System.getProperty("user.dir");

    @Override
    public String upload(GoodPassFilePath goodPassFilePath, InputStream inputStream) {
        createDirectory(basePath, goodPassFilePath.getDirectoryPath());

        File targetFilePath = Path.of(basePath, goodPassFilePath.getDirectoryPath(), goodPassFilePath.getFileName()).toFile();
        try (OutputStream targetOutputStream = toBufferedOutputStream(targetFilePath)) {
            byte[] buffer = new byte[8192];
            while (true) {
                int len = inputStream.read(buffer);
                if (len == -1) {
                    targetOutputStream.flush();
                    return targetFilePath.toString();
                }
                targetOutputStream.write(buffer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createDirectory(String basePath, String directoryPath) {
        Path path = Path.of(basePath, directoryPath);
        if (Files.exists(path)) {
            return;
        }

        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            throw new GoodPassSystemException("테스트 폴더를 생성할 수 없습니다. path = " + path);
        }
    }

    private OutputStream toBufferedOutputStream(File targetFilePath) {
        try {
            OutputStream fos = new FileOutputStream(targetFilePath);
            return new BufferedOutputStream(fos, 8192);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
