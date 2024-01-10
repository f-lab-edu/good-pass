package com.goodchalk.goodpass.infra.filestore;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.goodchalk.goodpass.exception.GoodPassSystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;

@Component
@RequiredArgsConstructor
public class AmazonS3FileStore implements FileStore{
    private final String bucketName;
    private final AmazonS3 amazonS3Source;

    @Override
    public void upload(GoodPassFilePath goodPassFilePath, InputStream inputStream) {
        ObjectMetadata objectMetaData = new ObjectMetadata();
        String directoryPath = goodPassFilePath.getDirectoryPath();
        String fileName = goodPassFilePath.getFileName();
        String targetFilePath = Path.of(directoryPath, fileName).toString();
        try {
            amazonS3Source.putObject(bucketName, targetFilePath, inputStream, objectMetaData);
        } catch(SdkClientException e) {
            throw new GoodPassSystemException(e);
        }
    }

    @Override
    public String getUrl(String bucketName, String directoryPath, String fileName) {
        String targetFilePath = Path.of(directoryPath, fileName).toString();
        URL url = amazonS3Source.getUrl(bucketName, targetFilePath);
        return url.toString();
    }
}