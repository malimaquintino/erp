package com.malimaquintino.erp.commonmslib.dto.email;

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
public class EmailInputDto {

    @NotNull(message = "E-mail address is required")
    @ApiModelProperty(notes = "E-mail's address")
    private String emailAddress;

    @ApiModelProperty(notes = "E-mail's observation")
    private String observation;
}
