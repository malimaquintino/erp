package com.malimaquintino.erp.commonmslib.dto.product;

import io.swagger.annotations.ApiModelProperty;

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
    private Long productTypeId;
}
