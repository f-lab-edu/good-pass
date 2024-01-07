package com.goodchalk.goodpass.infra;

import com.goodchalk.goodpass.infra.filestore.FileStore;

import java.io.*;
import java.nio.file.Path;

public class LocalFileStore implements FileStore {
    private final String basePath = System.getProperty("user.dir");

    @Override
    public void upload(String bucketName, String directoryPath, String fileName, InputStream inputStream) {
        File targetFilePath = Path.of(basePath, bucketName, directoryPath, fileName).toFile();

        try (OutputStream targetOutputStream = toBufferedOutputStream(targetFilePath)) {
            byte[] buffer = new byte[8192];
            while (true) {
                int len = inputStream.read(buffer);
                if (len == -1) {
                    targetOutputStream.flush();
                    return;
                }
                targetOutputStream.write(buffer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
