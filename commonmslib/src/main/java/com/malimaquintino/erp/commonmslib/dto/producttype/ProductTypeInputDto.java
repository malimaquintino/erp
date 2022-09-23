package com.malimaquintino.erp.commonmslib.dto.producttype;

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
public class ProductTypeInputDto {

    @NotNull(message = "Product type name is required")
    @ApiModelProperty(notes = "Product type's name")
    private String name;

    @NotNull(message = "Product active status is required")
    @ApiModelProperty(notes = "Product's active status")
    private Boolean active;
}
