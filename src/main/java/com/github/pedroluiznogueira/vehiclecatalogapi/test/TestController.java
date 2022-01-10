package com.github.pedroluiznogueira.vehiclecatalogapi.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/")
    public Test test() {
        Test test = new Test("working fine...");
        return testRepository.save(test);
    }
}
