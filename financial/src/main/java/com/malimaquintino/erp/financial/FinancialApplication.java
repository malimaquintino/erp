package com.malimaquintino.erp.financial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FinancialApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancialApplication.class, args);
    }

}
