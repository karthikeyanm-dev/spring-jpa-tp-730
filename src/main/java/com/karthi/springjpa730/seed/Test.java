package com.karthi.springjpa730.seed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Test implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application Started  : ) ");
    }
}
