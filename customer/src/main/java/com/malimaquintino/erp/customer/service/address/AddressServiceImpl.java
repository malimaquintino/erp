package com.malimaquintino.erp.customer.service.address;

import com.malimaquintino.erp.commonmslib.dto.address.AddressInputDto;
import com.malimaquintino.erp.customer.exceptions.AddressNotFoundException;
import com.malimaquintino.erp.customer.models.Address;
import com.malimaquintino.erp.customer.models.Contract;
import com.malimaquintino.erp.customer.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address findAddressById(long id) {
        return addressRepository.findById(id).orElseThrow(AddressNotFoundException::new);
    }

    @Override
    public Address addressInputDtoToEntity(AddressInputDto addressInputDto, Contract contract) {
        return Address.builder()
                .zipcode(addressInputDto.getZipcode())
                .street(addressInputDto.getStreet())
                .number(addressInputDto.getNumber())
                .neighborhood(addressInputDto.getNeighborhood())
                .city(addressInputDto.getCity())
                .state(addressInputDto.getState())
                .complement(addressInputDto.getComplement())
                .build();
    }
}
