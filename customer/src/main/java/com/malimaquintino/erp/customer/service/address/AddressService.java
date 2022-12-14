package com.malimaquintino.erp.customer.service.address;

import com.malimaquintino.erp.commonmslib.dto.address.AddressInputDto;
import com.malimaquintino.erp.customer.models.Address;
import com.malimaquintino.erp.customer.models.Contract;

public interface AddressService {
    Address findAddressById(long id);

    Address addressInputDtoToEntity(AddressInputDto addressInputDto, Contract contract);
}
