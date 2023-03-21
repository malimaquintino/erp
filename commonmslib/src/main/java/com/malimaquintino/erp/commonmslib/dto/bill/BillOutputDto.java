package com.malimaquintino.erp.commonmslib.dto.bill;

import com.malimaquintino.erp.commonmslib.enums.BillPaymentMethod;
import com.malimaquintino.erp.commonmslib.enums.BillStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillOutputDto {
    @ApiModelProperty(notes = "Bill's id")
    private Long id;

    @ApiModelProperty(notes = "Bill's products")
    private Set<BillProductOutputDto> billProducts = new HashSet<>();

    @ApiModelProperty(notes = "Bill's customer id")
    private Long customerId;

    @ApiModelProperty(notes = "Bill's customer name")
    private String customerName;

    @ApiModelProperty(notes = "Bill's customer document")
    private String customerDocument;

    @ApiModelProperty(notes = "Bill's due date")
    private LocalDate dueDate;

    @ApiModelProperty(notes = "Bill's total")
    private Double total;

    @ApiModelProperty(notes = "Bill's status")
    private BillStatus status;

    @ApiModelProperty(notes = "Bill's BillPayment method")
    private BillPaymentMethod paymentMethod;
}
