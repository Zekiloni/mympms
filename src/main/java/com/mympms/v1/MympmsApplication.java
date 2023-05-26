package com.mympms.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MympmsApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(MympmsApplication.class, args);
        } catch (Exception exception) {
            throw exception;
        }
    }
}
