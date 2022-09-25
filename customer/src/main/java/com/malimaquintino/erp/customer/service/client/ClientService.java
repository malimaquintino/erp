package com.malimaquintino.erp.customer.service.client;

import com.malimaquintino.erp.commonmslib.dto.client.ClientInputDto;
import com.malimaquintino.erp.customer.models.Client;

public interface ClientService {
    Client findClientById(long id);

    Client clientInputDtoToEntity(ClientInputDto clientInputDto);
}
