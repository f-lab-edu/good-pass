package com.goodchalk.goodpass.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("person")
@Getter
@NoArgsConstructor
public class Person {

    @Id
    private Long id;
    private String name;
    private Integer age;

    @Builder
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
