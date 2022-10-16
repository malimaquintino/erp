package com.malimaquintino.erp.financialworker.writer;

import com.malimaquintino.erp.commonmslib.dto.bill.BillInputDtoV2;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BillWriter {

    @Bean
    public ItemWriter<BillInputDtoV2> createBillWriter() {
        return billInputDtoV2List -> {
            billInputDtoV2List.forEach(obj -> {
                System.out.println(obj.getContractId() + " - " + obj.getCustomerName());
            });
        };
    }
}
