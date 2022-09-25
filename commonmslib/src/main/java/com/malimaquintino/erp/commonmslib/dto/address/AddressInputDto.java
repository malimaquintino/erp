package com.malimaquintino.erp.commonmslib.dto.address;

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
public class AddressInputDto {
    @NotNull(message = "Address zipcode is required")
    @ApiModelProperty(notes = "Address's zipcode")
    private String zipcode;

    @NotNull(message = "Address street is required")
    @ApiModelProperty(notes = "Address's street")
    private String street;

    @NotNull(message = "Address neighborhood is required")
    @ApiModelProperty(notes = "Address's neighborhood")
    private String neighborhood;

    @NotNull(message = "Address number is required")
    @ApiModelProperty(notes = "Address's number")
    private String number;

    @NotNull(message = "Address city is required")
    @ApiModelProperty(notes = "Address's city")
    private String city;

    @NotNull(message = "Address state is required")
    @ApiModelProperty(notes = "Address's state")
    private String state;

    @ApiModelProperty(notes = "Address's complement")
    private String complement;
}
