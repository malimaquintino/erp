package com.malimaquintino.erp.financialworker.steps;

import com.malimaquintino.erp.commonmslib.dto.bill.BillInputDtoV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CreateBillStep {
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step createBill(
            @Qualifier("createBillReader") ItemReader<BillInputDtoV2> itemReader,
            @Qualifier("createBillWriter") ItemWriter<BillInputDtoV2> itemWriter) {
        log.info("Step createBill");
        return stepBuilderFactory
                .get("createBill")
                .<BillInputDtoV2, BillInputDtoV2>chunk(100)
                .reader(itemReader)
                .writer(itemWriter)
                .faultTolerant().retry(Exception.class).retryLimit(3)
                .build();
    }
}
