package com.malimaquintino.erp.commonmslib.dto.contract;

import com.malimaquintino.erp.commonmslib.dto.address.AddressOutputDto;
import com.malimaquintino.erp.commonmslib.dto.client.ClientOutputDto;
import com.malimaquintino.erp.commonmslib.dto.email.EmailOutputDto;
import com.malimaquintino.erp.commonmslib.dto.phone.PhoneOutputDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractOutputDto {

    @ApiModelProperty(notes = "Contract's id")
    private Long id;

    @ApiModelProperty(notes = "Contract's client")
    private ClientOutputDto client;

    @ApiModelProperty(notes = "Contract's address")
    private AddressOutputDto address;

    @ApiModelProperty(notes = "Contract's emails")
    private Set<EmailOutputDto> emails = new HashSet<>();

    @ApiModelProperty(notes = "Contract's phones")
    private Set<PhoneOutputDto> phones = new HashSet<>();

    @ApiModelProperty(notes = "Contract's products")
    private Set<ContractProductOutputDto> products = new HashSet<>();

    @ApiModelProperty(notes = "Contract's due day")
    private Integer dueDay;

    @ApiModelProperty(notes = "Contract's total")
    private Double total;
}
