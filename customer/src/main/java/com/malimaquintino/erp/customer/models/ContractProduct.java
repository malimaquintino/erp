package com.malimaquintino.erp.customer.models;

import com.malimaquintino.erp.commonmslib.dto.contract.ContractProductOutputDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractProduct extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_product_sequence")
    @SequenceGenerator(name = "contract_product_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne
    private Contract contract;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_desc", nullable = false)
    private String productDesc;

    public ContractProductOutputDto toOutputDto() {
        return ContractProductOutputDto.builder()
                .productId(getProductId())
                .productName(getProductName())
                .productDesc(getProductDesc())
                .build();
    }
}
