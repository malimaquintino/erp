package com.malimaquintino.erp.financial.models;

import com.google.common.base.Strings;
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
public class Bill extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_sequence")
    @SequenceGenerator(name = "bill_sequence", allocationSize = 1)
    private Long id;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private Set<BillProduct> billProductList = new HashSet<>();

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_document", nullable = false)
    private String customerDocument;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "total", nullable = false)
    private Double total;

    @PreUpdate
    @PrePersist
    private void prePersist() {
        var docValidation = new DocumentValidationUtils();

        if (!Strings.isNullOrEmpty(getCustomerDocument())) {
            setCustomerDocument(docValidation.cleanFormatting(getCustomerDocument()));
        }
    }
}
