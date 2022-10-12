package com.malimaquintino.erp.fakergenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FakergeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FakergeneratorApplication.class, args);
    }

}
