package com.goodchalk.goodpass.domain;

import com.goodchalk.goodpass.GoodpassApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = GoodpassApplication.class)
public class Test{

    @Autowired
    private PersonRepository repository;


    @org.junit.jupiter.api.Test
    void name() {
        System.out.println(repository.findAll());
    }
}
