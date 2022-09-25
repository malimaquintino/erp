package com.malimaquintino.erp.customer.service.email;

import com.malimaquintino.erp.commonmslib.dto.email.EmailInputDto;
import com.malimaquintino.erp.customer.exceptions.EmailNotFoundException;
import com.malimaquintino.erp.customer.models.Email;
import com.malimaquintino.erp.customer.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;

    @Override
    public Email findEmailById(long id) {
        return emailRepository.findById(id).orElseThrow(EmailNotFoundException::new);
    }

    @Override
    public Email emailInputDtoToEntity(EmailInputDto emailInputDto) {
        return Email.builder()
                .emailAddress(emailInputDto.getEmailAddress())
                .observation(emailInputDto.getObservation())
                .build();
    }
}
