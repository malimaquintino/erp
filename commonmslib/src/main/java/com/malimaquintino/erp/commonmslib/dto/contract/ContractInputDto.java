package com.malimaquintino.erp.commonmslib.dto.contract;

import com.malimaquintino.erp.commonmslib.dto.address.AddressInputDto;
import com.malimaquintino.erp.commonmslib.dto.client.ClientInputDto;
import com.malimaquintino.erp.commonmslib.dto.email.EmailInputDto;
import com.malimaquintino.erp.commonmslib.dto.phone.PhoneInputDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractInputDto {

    @NotNull(message = "Contract client is required")
    @ApiModelProperty(notes = "Contract's client")
    private ClientInputDto client;

    @NotNull(message = "Contract address is required")
    @ApiModelProperty(notes = "Contract's address")
    private AddressInputDto address;

    @NotNull(message = "Contract emails is required")
    @ApiModelProperty(notes = "Contract's emails")
    private Set<EmailInputDto> emails = new HashSet<>();

    @NotNull(message = "Contract phones is required")
    @ApiModelProperty(notes = "Contract's phones")
    private Set<PhoneInputDto> phones = new HashSet<>();

    @NotNull(message = "Contract products is required")
    @ApiModelProperty(notes = "Contract's products")
    private List<Long> products = new ArrayList<>();

    @NotNull(message = "Contract due day is required")
    @ApiModelProperty(notes = "Contract's due day")
    @Range(min= 1, max= 30)
    private Integer dueDay;
}
