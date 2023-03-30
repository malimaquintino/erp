package com.malimaquintino.erp.reporter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReporterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReporterApplication.class, args);
    }

}
