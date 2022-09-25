package com.malimaquintino.erp.customer.service.client;

import com.malimaquintino.erp.commonmslib.dto.client.ClientInputDto;
import com.malimaquintino.erp.customer.exceptions.ClientNotFoundException;
import com.malimaquintino.erp.customer.models.Client;
import com.malimaquintino.erp.customer.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client findClientById(long id) {
        return clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public Client clientInputDtoToEntity(ClientInputDto clientInputDto) {
        return Client.builder()
                .name(clientInputDto.getName())
                .personType(clientInputDto.getPersonType())
                .document(clientInputDto.getDocument())
                .fantasyName(clientInputDto.getFantasyName())
                .birth(clientInputDto.getBirth())
                .build();
    }
}
