package com.goodchalk.goodpass.infra.filestore;

import java.io.InputStream;

public interface FileStore {
    void upload(String bucketName, String directoryPath, String fileName, InputStream inputStream);
}
