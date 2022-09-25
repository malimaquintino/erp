package com.malimaquintino.erp.commonmslib.dto.phone;

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
public class PhoneInputDto {
    @NotNull(message = "Phone number is required")
    @ApiModelProperty(notes = "Phone's number")
    private String phoneNumber;

    @ApiModelProperty(notes = "Phone's observation")
    private String observation;
}
