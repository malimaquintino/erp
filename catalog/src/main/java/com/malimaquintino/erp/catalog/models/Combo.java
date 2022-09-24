package com.malimaquintino.erp.catalog.models;

import com.malimaquintino.erp.commonmslib.dto.combo.ComboOutputDto;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Combo extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "combo_sequence")
    @SequenceGenerator(name = "combo_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "combo_product",
            joinColumns = @JoinColumn(name = "combo_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;

    public ComboOutputDto toOutputDto() {
        return ComboOutputDto.builder()
                .id(getId())
                .name(getName())
                .description(getDescription())
                .products(products.stream().map(Product::toOutputDto).toList())
                .build();
    }
}
