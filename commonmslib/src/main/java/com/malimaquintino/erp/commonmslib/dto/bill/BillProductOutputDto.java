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
public class BillProductOutputDto {

    @ApiModelProperty(notes = "Bill product's id")
    private Long id;

    @ApiModelProperty(notes = "Bill's product id")
    private Long productId;

    @ApiModelProperty(notes = "Bill's product name")
    private String productName;

    @ApiModelProperty(notes = "Bill's product description")
    private String productDescription;

    @ApiModelProperty(notes = "Bill's product type")
    private String productType;

    @ApiModelProperty(notes = "Bill's product price")
    private Double productPrice;
}
