package com.malimaquintino.erp.commonmslib.dto.product;

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
public class ProductInputDto {
    @NotNull(message = "Product name is required")
    @ApiModelProperty(notes = "Product's name")
    private String name;

    @NotNull(message = "Product description is required")
    @ApiModelProperty(notes = "Product's description")
    private String description;

    @NotNull(message = "Product price is required")
    @ApiModelProperty(notes = "Product's price")
    private Double price;

    @NotNull(message = "Product  type id is required")
    @ApiModelProperty(notes = "Product's type id")
    private Long productTypeId;
}
