package com.malimaquintino.erp.customer.models;

import com.malimaquintino.erp.commonmslib.dto.email.EmailOutputDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Email extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_sequence")
    @SequenceGenerator(name = "email_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne
    private Contract contract;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "observation")
    private String observation;

    public EmailOutputDto toOutputDto() {
        return EmailOutputDto.builder()
                .id(getId())
                .emailAddress(getEmailAddress())
                .observation(getObservation())
                .build();
    }
}
