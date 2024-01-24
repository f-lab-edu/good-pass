package com.goodchalk.goodpass.infra.filestore;

import java.io.InputStream;

public interface FileStore {
    String upload(GoodPassFilePath goodPassFilePath, InputStream inputStream);

}
