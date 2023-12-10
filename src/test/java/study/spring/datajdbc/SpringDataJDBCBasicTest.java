package study.spring.datajdbc;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.support.JdbcRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import study.spring.datajdbc.domain.PersonRepository;
import study.spring.lombok.domain.Person;

import javax.sql.DataSource;
import java.util.Optional;

@SpringBootTest
@AutoConfigureDataJdbc
@Import(SpringDataJDBCBasicTest.ApplicationConfig.class)
public class SpringDataJDBCBasicTest {
    @Autowired
    private ApplicationContext applicationContext;

    // 아래 코드 추가시 error 발생
    // Error creating bean with name 'personRepository' defined in study.spring.datajdbc.domain.PersonRepository
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void test1() {
        String[] beans = applicationContext.getBeanDefinitionNames();

        for (String bean : beans) {
            System.out.println(bean);
        }
    }

    @Test
    public void test2() {
    }

    @Configuration
    @EnableJdbcRepositories
    public static class ApplicationConfig extends AbstractJdbcConfiguration {
        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/GOOD_PASS?characterEncoding=UTF-8");
            dataSource.setUsername("root");
            dataSource.setPassword("xxxx");
            return dataSource;
        }

        @Bean
        NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
            return new NamedParameterJdbcTemplate(dataSource);
        }

        @Bean
        TransactionManager transactionManager(DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

    }
}
