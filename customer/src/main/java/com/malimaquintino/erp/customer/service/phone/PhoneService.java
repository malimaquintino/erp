package com.malimaquintino.erp.customer.service.phone;

import com.malimaquintino.erp.commonmslib.dto.phone.PhoneInputDto;
import com.malimaquintino.erp.customer.models.Contract;
import com.malimaquintino.erp.customer.models.Phone;

public interface PhoneService {
    Phone findPhoneById(long id);

    Phone phoneInputDtoToEntity(PhoneInputDto phoneInputDto, Contract contract);
}
