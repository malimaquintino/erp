package com.malimaquintino.erp.customer.models;

import com.malimaquintino.erp.commonmslib.dto.email.EmailOutputDto;
import com.malimaquintino.erp.commonmslib.dto.phone.PhoneOutputDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_sequence")
    @SequenceGenerator(name = "phone_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne
    private Contract contract;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "observation")
    private String observation;

    public PhoneOutputDto toOutputDto(){
        return PhoneOutputDto.builder()
                .id(getId())
                .phoneNumber(getPhoneNumber())
                .observation(getObservation())
                .build();
    }
}
