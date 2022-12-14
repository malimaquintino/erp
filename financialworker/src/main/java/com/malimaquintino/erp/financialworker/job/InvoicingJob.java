package com.malimaquintino.erp.financialworker.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@EnableBatchProcessing
@Configuration
@RequiredArgsConstructor
public class InvoicingJob {

    private final JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job createInvoice(@Qualifier("createBill") Step createBill) {
        log.info("Start create invoices");
        return jobBuilderFactory.get("createInvoice")
                .start(createBill)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
