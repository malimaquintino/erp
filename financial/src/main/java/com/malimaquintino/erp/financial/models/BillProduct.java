package com.malimaquintino.erp.financial.models;

import com.malimaquintino.erp.commonmslib.dto.bill.BillProductOutputDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillProduct extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_product_sequence")
    @SequenceGenerator(name = "bill_product_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "product_type", nullable = false)
    private String productType;

    @Column(name = "product_price", nullable = false)
    private Double productPrice;

    public BillProductOutputDto toOutputDto() {
        return BillProductOutputDto.builder()
                .id(getId())
                .productId(getProductId())
                .productName(getProductName())
                .productDescription(getProductDescription())
                .productType(getProductType())
                .productPrice(getProductPrice())
                .build();
    }
}
