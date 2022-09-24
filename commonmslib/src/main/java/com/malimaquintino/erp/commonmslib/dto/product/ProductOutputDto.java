package com.malimaquintino.erp.commonmslib.dto.product;

import com.malimaquintino.erp.commonmslib.dto.producttype.ProductTypeOutputDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductOutputDto {
    @ApiModelProperty(notes = "Product's id")
    private Long id;

    @ApiModelProperty(notes = "Product's name")
    private String name;

    @ApiModelProperty(notes = "Product's description")
    private String description;

    @ApiModelProperty(notes = "Product's price")
    private Double price;

    @ApiModelProperty(notes = "Product's type id")
    private ProductTypeOutputDto productType;
}
