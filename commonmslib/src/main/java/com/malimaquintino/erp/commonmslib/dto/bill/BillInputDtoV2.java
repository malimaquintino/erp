package com.malimaquintino.erp.commonmslib.dto.bill;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillInputDtoV2 {

    @NotNull(message = "Bill's contract id is required")
    @ApiModelProperty(notes = "Bill's contract id")
    private Long contractId;

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
}
