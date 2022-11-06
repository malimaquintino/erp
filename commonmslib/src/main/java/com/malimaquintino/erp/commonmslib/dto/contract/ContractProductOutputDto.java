package com.malimaquintino.erp.commonmslib.dto.contract;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractProductOutputDto {
    @ApiModelProperty(notes = "Contract product's id")
    private Long productId;

    @ApiModelProperty(notes = "Contract product's name")
    private String productName;

    @ApiModelProperty(notes = "Contract product's description")
    private String productDesc;

    @ApiModelProperty(notes = "Contract product's value")
    private Double value;
}
