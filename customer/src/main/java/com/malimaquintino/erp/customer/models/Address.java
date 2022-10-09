package com.malimaquintino.erp.customer.models;

import com.google.common.base.Strings;
import com.malimaquintino.erp.commonmslib.dto.address.AddressOutputDto;
import com.malimaquintino.erp.commonmslib.util.StringUtils;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    @SequenceGenerator(name = "address_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "zipcode", nullable = false)
    private String zipcode;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "complement")
    private String complement;

    public AddressOutputDto toOutputDto() {
        return AddressOutputDto.builder()
                .id(getId())
                .zipcode(getZipcode())
                .street(getStreet())
                .neighborhood(getNeighborhood())
                .number(getNumber())
                .city(getCity())
                .state(getState())
                .complement(getComplement())
                .build();
    }

    @PreUpdate
    @PrePersist
    private void prePersist() {
        if (!Strings.isNullOrEmpty(getZipcode())) {
            setZipcode(StringUtils.onlyNumbers(getZipcode()));
        }
    }
}
