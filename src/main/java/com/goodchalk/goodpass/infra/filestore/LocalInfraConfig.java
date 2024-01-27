package com.goodchalk.goodpass.infra.filestore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalInfraConfig {
    @Bean
    public LocalFileStore localFileStore() {
        return new LocalFileStore();
    }
}
