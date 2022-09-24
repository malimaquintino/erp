package com.malimaquintino.erp.commonmslib.dto.combo;

import com.malimaquintino.erp.commonmslib.dto.product.ProductOutputDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComboOutputDto {
    @ApiModelProperty(notes = "Combo's id")
    private Long id;

    @ApiModelProperty(notes = "Combo's name")
    private String name;

    @ApiModelProperty(notes = "Combo's description")
    private String description;

    @ApiModelProperty(notes = "Combo's products")
    private List<ProductOutputDto> products;
}
