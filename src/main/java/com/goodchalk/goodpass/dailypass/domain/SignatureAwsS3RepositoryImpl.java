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

    private final SignatureFileNameConverter signatureFileNameConverter = new SignatureFileNameConverter(15);

    private final AmazonS3 amazonS3Source;

    @Override
    public void upload(Signature signature) {
        String signatureFileName = signatureFileNameConverter.convert(signature);
        try {
            amazonS3Source.putObject(BUCKET_NAME, FOLDER_NAME + signatureFileName, signature.getSignatureInputStream(), OBJECT_METADATA);
        } catch (AmazonS3Exception e) {
            throw new GoodPassSystemException(e);
        } catch(SdkClientException e) {
            throw new GoodPassSystemException(e);
        }
    }
}
