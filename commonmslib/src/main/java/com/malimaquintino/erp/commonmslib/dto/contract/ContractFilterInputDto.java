package com.malimaquintino.erp.commonmslib.dto.contract;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractFilterInputDto {

    @ApiModelProperty(notes = "Contract's id")
    private Long contractId;

    @ApiModelProperty(notes = "Contract's client name")
    private String clientName;

    @ApiModelProperty(notes = "Contract's client document")
    private String clientDocument;

    @ApiModelProperty(notes = "Contract's due day")
    @Range(min = 1, max = 30)
    private Integer dueDay;
}
