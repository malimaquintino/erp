package com.malimaquintino.erp.catalog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.malimaquintino.erp.commonmslib.dto.product.ProductOutputDto;
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
public class Product extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @SequenceGenerator(name = "product_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToOne
    private ProductType productType;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private Set<Combo> combos = new HashSet<>();

    public ProductOutputDto toOutputDto() {
        return ProductOutputDto.builder()
                .id(getId())
                .name(getName())
                .description(getDescription())
                .price(getPrice())
                .productType(getProductType().toOutputDto())
                .build();
    }
}
