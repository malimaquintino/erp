package com.malimaquintino.erp.financialworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FinancialWorkerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialWorkerMsApplication.class, args);
	}

}
