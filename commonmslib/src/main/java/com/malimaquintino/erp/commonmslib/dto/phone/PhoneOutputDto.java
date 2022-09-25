package com.malimaquintino.erp.commonmslib.dto.phone;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneOutputDto {

    @ApiModelProperty(notes = "Phone's id")
    private Long id;

    @ApiModelProperty(notes = "Phone's number")
    private String phoneNumber;

    @ApiModelProperty(notes = "Phone's observation")
    private String observation;
}
