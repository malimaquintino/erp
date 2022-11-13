package com.malimaquintino.erp.financialworker.writer;

import com.malimaquintino.erp.commonmslib.dto.bill.BillInputDtoV2;
import com.malimaquintino.erp.financialworker.requests.FinancialRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@AllArgsConstructor
public class BillWriter {

    private final FinancialRequest financialRequest;

    @Bean
    public ItemWriter<BillInputDtoV2> createBillWriter() {
        log.info("sending to endpoint");
        return billInputDtoV2List -> billInputDtoV2List.forEach(financialRequest::postBill);
    }
}
