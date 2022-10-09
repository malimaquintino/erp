package com.malimaquintino.erp.customer.models;

import com.google.common.base.Strings;
import com.malimaquintino.erp.commonmslib.dto.client.ClientOutputDto;
import com.malimaquintino.erp.commonmslib.enums.PersonType;
import com.malimaquintino.erp.commonmslib.util.DocumentValidationUtils;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_sequence")
    @SequenceGenerator(name = "client_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "person_type", nullable = false)
    private PersonType personType;

    @Column(name = "document", nullable = false)
    private String document;

    @Column(name = "fantasy_name")
    private String fantasyName;

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Contract> contracts = new HashSet<>();

    public ClientOutputDto toOutputDto() {
        return ClientOutputDto.builder()
                .id(getId())
                .name(getName())
                .personType(getPersonType())
                .document(getDocument())
                .fantasyName(getFantasyName())
                .birth(getBirth())
                .build();
    }

    @PreUpdate
    @PrePersist
    private void prePersist() {
        var docValidation = new DocumentValidationUtils();

        if (!Strings.isNullOrEmpty(getDocument())) {
            setDocument(docValidation.cleanFormatting(getDocument()));
        }
    }
}
