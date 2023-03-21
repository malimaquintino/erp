package com.malimaquintino.erp.fakergenerator.services.customers;

import com.malimaquintino.erp.commonmslib.dto.contract.ContractInputDto;
import com.malimaquintino.erp.fakergenerator.requests.CustomerRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

import static com.malimaquintino.erp.fakergenerator.mocks.CustomerMock.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRequest customerRequest;

    @Bean
    public void generateCustomer() {
        createContract();
    }

    private void createContract() {
        for (int i = 0; i <= 999; i++) {
            log.info("creating contract");
            customerRequest.createContract(ContractInputDto.builder()
                    .address(getAddress())
                    .client(getClient())
                    .emails(new HashSet<>(Collections.singletonList(getEmail())))
                    .phones(new HashSet<>(Collections.singletonList(getPhone())))
                    .dueDay(randomDueDay())
                    .products(randomProductList())
                    .paymentMethod(randomPaymentMethod())
                    .build()
            );
        }
    }
}
