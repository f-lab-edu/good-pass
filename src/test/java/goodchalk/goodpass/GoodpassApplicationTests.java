package goodchalk.goodpass;

import com.goodchalk.goodpass.DevConfig;
import com.goodchalk.goodpass.GoodpassApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = GoodpassApplication.class)
@ActiveProfiles("dev")
class GoodpassApplicationTests {
    @Test
    void contextLoads() {
    }
}
