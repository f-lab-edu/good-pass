package com.goodchalk.goodpass.infra.filestore;

import java.io.InputStream;

public interface FileStore {
    void upload(GoodPassFilePath goodPassFilePath, InputStream inputStream);

    String getUrl(String bucketName, String directoryPath, String fileName);
}
