package com.malimaquintino.erp.commonmslib.dto.producttype;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypeOutputDto {
    @ApiModelProperty(notes = "Product's id")
    private Long id;

    @ApiModelProperty(notes = "Product type's name")
    private String name;

    @ApiModelProperty(notes = "Product's active status")
    private Boolean active;
}
