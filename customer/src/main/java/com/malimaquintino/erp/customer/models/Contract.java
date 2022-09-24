package com.malimaquintino.erp.customer.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
}
