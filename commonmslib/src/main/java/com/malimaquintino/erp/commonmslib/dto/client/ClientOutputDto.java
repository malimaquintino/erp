package com.malimaquintino.erp.commonmslib.dto.client;

import com.malimaquintino.erp.commonmslib.enums.PersonType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientOutputDto {
    @ApiModelProperty(notes = "Client's id")
    private Long id;

    @ApiModelProperty(notes = "Client's name")
    private String name;

    @ApiModelProperty(notes = "Client's person type")
    private PersonType personType;

    @ApiModelProperty(notes = "Client's document")
    private String document;

    @ApiModelProperty(notes = "Client's fantasy name")
    private String fantasyName;

    @ApiModelProperty(notes = "Client's birth")
    private LocalDate birth;
}
