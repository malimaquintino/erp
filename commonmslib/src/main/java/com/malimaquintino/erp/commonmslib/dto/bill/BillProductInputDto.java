package com.malimaquintino.erp.commonmslib.dto.bill;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillProductInputDto {

    @NotNull(message = "Bill product id is required")
    @ApiModelProperty(notes = "Bill's product id")
    private Long productId;

    @NotNull(message = "Bill product name is required")
    @ApiModelProperty(notes = "Bill's product name")
    private String productName;

    @NotNull(message = "Bill product description is required")
    @ApiModelProperty(notes = "Bill's product description")
    private String productDescription;

    @NotNull(message = "Bill product type is required")
    @ApiModelProperty(notes = "Bill's product type")
    private String productType;

    @NotNull(message = "Bill product price is required")
    @ApiModelProperty(notes = "Bill's product price")
    private Double productPrice;
}
