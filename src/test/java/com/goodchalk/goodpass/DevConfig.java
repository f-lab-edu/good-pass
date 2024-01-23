package com.goodchalk.goodpass;

import com.goodchalk.goodpass.infra.filestore.FileStore;
import com.goodchalk.goodpass.infra.filestore.LocalFileStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    @Bean
    public FileStore fileStore() {
        return new LocalFileStore();
    }
}
