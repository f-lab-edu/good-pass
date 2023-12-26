package com.goodchalk.goodpass.dailypass.domain.stub;

import com.goodchalk.goodpass.dailypass.domain.Signature;
import com.goodchalk.goodpass.dailypass.domain.SignatureRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import com.goodchalk.goodpass.exception.GoodPassSystemException;

import java.io.*;

public class SignatureStubRepository implements SignatureRepository {
    public static final int BUFFER_SIZE = 8192;
    @Override
    public void upload(Signature signature) {
        InputStream signatureInputStream = signature.getSignatureInputStream();
        String signatureFileName = String.format("%10d", signature.getSignatureId());
        InputStream bis = new BufferedInputStream(signatureInputStream, BUFFER_SIZE);
        try (OutputStream fos = new FileOutputStream("/Users/dgyim/IdeaProjects/goodpass/src/test/resources/" + signatureFileName);
             OutputStream bos = new BufferedOutputStream(fos, BUFFER_SIZE);){
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = bis.read(buffer);
            if (len == -1) {
                bos.flush();
                return;
            }
            bos.write(buffer, 0, len);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exist(Long dailyPassId) {
        throw new GoodPassSystemException("미구현");
    }
}
