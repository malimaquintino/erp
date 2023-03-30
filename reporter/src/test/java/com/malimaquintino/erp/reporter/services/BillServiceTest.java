package com.malimaquintino.erp.reporter.services;

import com.malimaquintino.erp.commonmslib.dto.bill.BillInputDto;
import com.malimaquintino.erp.commonmslib.dto.bill.BillProductInputDto;
import com.malimaquintino.erp.commonmslib.enums.BillPaymentMethod;
import com.malimaquintino.erp.reporter.models.Bill;
import com.malimaquintino.erp.reporter.repository.BillRepository;
import com.malimaquintino.erp.reporter.requests.CustomerRequest;
import com.malimaquintino.erp.reporter.services.bill.BillServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class BillServiceTest {

    @Mock
    private BillRepository billRepository;

    @Mock
    private CustomerRequest customerRequest;

    @InjectMocks
    private BillServiceImpl billService;

    @Test
    public void shouldThrowBillAlreadyExistsExceptionWhenSaveBill() {
        Set<BillProductInputDto> productInputDtoSet = new HashSet<>();
        productInputDtoSet.add(BillProductInputDto.builder().build());
        var billInput = BillInputDto.builder()
                .billProducts(productInputDtoSet)
                .customerId(12L)
                .customerName("Matheus Quintino")
                .customerDocument("12345678901")
                .dueDate(LocalDate.now())
                .total(150.0)
                .paymentMethod(BillPaymentMethod.PIX)
                .build();
        var bill = Bill.builder()
                .customerId(12L)
                .customerName("Matheus Quintino")
                .customerDocument("12345678901")
                .dueDate(LocalDate.now())
                .total(150.0)
                .paymentMethod(BillPaymentMethod.PIX)
                .build();

        Mockito.when(billRepository.findByCustomerDocumentAndDueDate(billInput.getCustomerDocument(), billInput.getDueDate()))
                .thenReturn(Optional.of(bill));

        var response = billService.createCustomerBill(billInput);

        String expectedMessage = "There is already a bill created for this customer with this due date";
        assertTrue(response.getMessage().contains(expectedMessage));
    }

}
