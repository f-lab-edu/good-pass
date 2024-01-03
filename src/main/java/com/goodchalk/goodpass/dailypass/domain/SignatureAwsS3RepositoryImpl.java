package com.goodchalk.goodpass.dailypass.domain;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.goodchalk.goodpass.exception.GoodPassSystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.InputStream;

@Repository
@RequiredArgsConstructor
public class SignatureAwsS3RepositoryImpl implements SignatureRepository {
    private static final String BUCKET_NAME = "goodpass";
    private static final String FOLDER_NAME = "dailypass/";
    private static final ObjectMetadata OBJECT_METADATA = new ObjectMetadata();
    {
        OBJECT_METADATA.setContentType("image/jpeg");
    }

    private final AmazonS3 amazonS3Source;

    @Override
    public void upload(Signature signature) {
        Long signatureId = signature.getSignatureId();
        InputStream signatureInputStream = signature.getSignatureInputStream();

        //signature 객체 넣고 싶은 부분이지만 일부러 넣지 않음
        //file system의 체계를 관장하는 것은 signatrueRepository가 담당할 책임이 있다고 판단
        String signatureFileName = String.format("%10d", signatureId);
        try {
            amazonS3Source.putObject(BUCKET_NAME, FOLDER_NAME+signatureFileName, signatureInputStream, OBJECT_METADATA);
        } catch (AmazonS3Exception e) {
            throw new GoodPassSystemException(e);
        } catch(SdkClientException e) {
            throw new GoodPassSystemException(e);
        }
    }
}
