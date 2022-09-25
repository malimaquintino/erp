package com.malimaquintino.erp.commonmslib.dto.client;

import com.malimaquintino.erp.commonmslib.enums.PersonType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientInputDto {

    @NotNull(message = "Client name is required")
    @ApiModelProperty(notes = "Client's name")
    private String name;

    @NotNull(message = "Client person type is required")
    @ApiModelProperty(notes = "Client's person type")
    private PersonType personType;

    @NotNull(message = "Client document is required")
    @ApiModelProperty(notes = "Client's document")
    private String document;

    @ApiModelProperty(notes = "Client's fantasy name")
    private String fantasyName;

    @NotNull(message = "Client birth is required")
    @ApiModelProperty(notes = "Client's birth")
    private LocalDate birth;
}
