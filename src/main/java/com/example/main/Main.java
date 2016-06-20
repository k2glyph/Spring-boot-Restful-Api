package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by dinesh on 6/20/2016.
 */
@EnableAutoConfiguration
@ComponentScan("com.example.")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
