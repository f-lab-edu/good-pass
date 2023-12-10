package study.spring.datajdbc.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
