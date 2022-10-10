package com.malimaquintino.erp.financialworker.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class InvoicingJob {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job createInvoice(
            @Qualifier("testOne") Step testOne,
            @Qualifier("testTwo") Step testTwo
    ) {
        return jobBuilderFactory.get("createInvoice")
                .start(testOne)
                .next(testTwo)
                .build();
    }
}
