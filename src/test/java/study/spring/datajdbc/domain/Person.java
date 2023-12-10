package study.spring.datajdbc.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
public class Person {
    private final Long id;
    private final String name;
    private final Integer age;
}
