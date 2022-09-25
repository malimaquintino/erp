package com.malimaquintino.erp.commonmslib.dto.email;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailOutputDto {
    @ApiModelProperty(notes = "E-mail's id")
    private Long id;

    @ApiModelProperty(notes = "E-mail's address")
    private String emailAddress;

    @ApiModelProperty(notes = "E-mail's observation")
    private String observation;
}
