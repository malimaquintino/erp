package com.malimaquintino.erp.catalog.models;

import com.malimaquintino.erp.commonmslib.dto.producttype.ProductTypeOutputDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductType extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_type_sequence")
    @SequenceGenerator(name = "product_type_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "active", nullable = false)
    private Boolean active;

    public ProductTypeOutputDto toOutputDto() {
        return ProductTypeOutputDto.builder()
                .id(getId())
                .name(getName())
                .active(getActive())
                .build();
    }
}
