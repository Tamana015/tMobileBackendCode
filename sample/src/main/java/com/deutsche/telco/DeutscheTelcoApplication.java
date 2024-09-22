package com.deutsche.telco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan({"com.deutsche.telco"})
public class DeutscheTelcoApplication {
    public static void main(String[] args)  {
        SpringApplication.run(DeutscheTelcoApplication.class, args);
    }
}