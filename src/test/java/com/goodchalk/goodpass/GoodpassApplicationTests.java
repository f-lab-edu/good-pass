package com.goodchalk.goodpass;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = GoodpassApplication.class)
@ActiveProfiles("dev")
class GoodpassApplicationTests {
    @Test
    void contextLoads() {
    }
}
