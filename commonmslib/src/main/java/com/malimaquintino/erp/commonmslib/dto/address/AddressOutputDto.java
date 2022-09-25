package com.malimaquintino.erp.commonmslib.dto.address;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressOutputDto {
    @ApiModelProperty(notes = "Address's id")
    private Long id;

    @ApiModelProperty(notes = "Address's zipcode")
    private String zipcode;

    @ApiModelProperty(notes = "Address's street")
    private String street;

    @ApiModelProperty(notes = "Address's neighborhood")
    private String neighborhood;

    @ApiModelProperty(notes = "Address's number")
    private String number;

    @ApiModelProperty(notes = "Address's city")
    private String city;

    @ApiModelProperty(notes = "Address's state")
    private String state;

    @ApiModelProperty(notes = "Address's complement")
    private String complement;
}
