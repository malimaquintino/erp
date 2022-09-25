package com.malimaquintino.erp.customer.service.phone;

import com.malimaquintino.erp.commonmslib.dto.phone.PhoneInputDto;
import com.malimaquintino.erp.customer.exceptions.PhoneNotFoundException;
import com.malimaquintino.erp.customer.models.Phone;
import com.malimaquintino.erp.customer.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Override
    public Phone findPhoneById(long id) {
        return phoneRepository.findById(id).orElseThrow(PhoneNotFoundException::new);
    }

    @Override
    public Phone phoneInputDtoToEntity(PhoneInputDto phoneInputDto) {
        return Phone.builder()
                .phoneNumber(phoneInputDto.getPhoneNumber())
                .observation(phoneInputDto.getObservation())
                .build();
    }
}
