package com.malimaquintino.erp.commonmslib.dto.bill;

import com.malimaquintino.erp.commonmslib.enums.BillPaymentMethod;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillInputDto {

    @NotNull(message = "Bill products is required")
    @ApiModelProperty(notes = "Bill's products")
    private Set<BillProductInputDto> billProducts = new HashSet<>();

    @NotNull(message = "Bill's customer id is required")
    @ApiModelProperty(notes = "Bill's customer id")
    private Long customerId;

    @NotNull(message = "Bill's customer name is required")
    @ApiModelProperty(notes = "Bill's customer name")
    private String customerName;

    @NotNull(message = "Bill's customer document is required")
    @ApiModelProperty(notes = "Bill's customer document")
    private String customerDocument;

    @NotNull(message = "Bill's due date is required")
    @ApiModelProperty(notes = "Bill's due date")
    private LocalDate dueDate;

    @NotNull(message = "Bill's total is required")
    @ApiModelProperty(notes = "Bill's total")
    private Double total;

    @NotNull(message = "Bill's payment method is required")
    @ApiModelProperty(notes = "Bill's payment method")
    private BillPaymentMethod paymentMethod;
}
