package com.malimaquintino.erp.commonmslib.dto.contract;

import com.malimaquintino.erp.commonmslib.dto.address.AddressInputDto;
import com.malimaquintino.erp.commonmslib.dto.client.ClientInputDto;
import com.malimaquintino.erp.commonmslib.dto.email.EmailInputDto;
import com.malimaquintino.erp.commonmslib.dto.phone.PhoneInputDto;
import com.malimaquintino.erp.commonmslib.dto.product.ProductOutputDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractOutputDto {

    @ApiModelProperty(notes = "Contract's id")
    private Long id;

    @ApiModelProperty(notes = "Contract's client")
    private ClientInputDto client;

    @ApiModelProperty(notes = "Contract's address")
    private AddressInputDto address;

    @ApiModelProperty(notes = "Contract's emails")
    private Set<EmailInputDto> emails = new HashSet<>();

    @ApiModelProperty(notes = "Contract's phones")
    private Set<PhoneInputDto> phones = new HashSet<>();

    @ApiModelProperty(notes = "Contract's products")
    private List<ProductOutputDto> products = new ArrayList<>();
}
