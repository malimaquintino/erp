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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Email> emails = new HashSet<>();

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Phone> phones = new HashSet<>();

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ContractProduct> products = new HashSet<>();

    @Column(name = "due_day", nullable = false)
    private Integer dueDay;

    public ContractOutputDto toOutputDto() {
        return ContractOutputDto.builder()
                .id(getId())
                .client(getClient().toOutputDto())
                .address(getAddress().toOutputDto())
                .emails(getEmails().stream().map(Email::toOutputDto).collect(Collectors.toSet()))
                .phones(getPhones().stream().map(Phone::toOutputDto).collect(Collectors.toSet()))
                .products(getProducts().stream().map(ContractProduct::toOutputDto).collect(Collectors.toSet()))
                .dueDay(getDueDay())
                .build();
    }
}
