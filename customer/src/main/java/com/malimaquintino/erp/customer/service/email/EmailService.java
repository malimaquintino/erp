package com.malimaquintino.erp.customer.service.email;

import com.malimaquintino.erp.commonmslib.dto.email.EmailInputDto;
import com.malimaquintino.erp.customer.models.Contract;
import com.malimaquintino.erp.customer.models.Email;

public interface EmailService {
    Email findEmailById(long id);

    Email emailInputDtoToEntity(EmailInputDto emailInputDto, Contract contract);
}
