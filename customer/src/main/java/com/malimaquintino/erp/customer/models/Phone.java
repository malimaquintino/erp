package com.malimaquintino.erp.customer.models;

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
}
