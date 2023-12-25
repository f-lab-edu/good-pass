package com.goodchalk.goodpass.dailypass.infra;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//위치가 애매한데, 일단 여기다 두고 윤곽이 보일 시 변경 예정
@Configuration
@ConfigurationProperties(prefix = "amazons3")
@Setter
public class AmazonS3InfraConfig {
    private String endPoint;
    private String regionName;
    private String accessKey;
    private String secretKey;

    @Bean
    public AmazonS3 amazonS3Source() {
        return AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, regionName))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .build();
    }
}

