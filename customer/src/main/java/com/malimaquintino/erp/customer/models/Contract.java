package com.malimaquintino.erp.customer.models;

import com.malimaquintino.erp.commonmslib.dto.contract.ContractOutputDto;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contract extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_sequence")
    @SequenceGenerator(name = "contract_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne
    private Client client;

    @OneToOne
    private Address address;

    @OneToMany
    private Set<Email> emails = new HashSet<>();

    @OneToMany
    private Set<Phone> phones = new HashSet<>();

    @OneToMany
    private Set<ContractProduct> products = new HashSet<>();

    public ContractOutputDto toOutputDto() {
        return ContractOutputDto.builder()
                .id(getId())
                .client(getClient().toOutputDto())
                .address(getAddress().toOutputDto())
                .emails(getEmails().stream().map(Email::toOutputDto).collect(Collectors.toSet()))
                .phones(getPhones().stream().map(Phone::toOutputDto).collect(Collectors.toSet()))
                .products(getProducts().stream().map(ContractProduct::toOutputDto).collect(Collectors.toSet()))
                .build();
    }
}
