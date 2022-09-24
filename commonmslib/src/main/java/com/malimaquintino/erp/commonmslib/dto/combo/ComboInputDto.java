package com.malimaquintino.erp.commonmslib.dto.combo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComboInputDto {
    @NotNull(message = "Combo name is required")
    @ApiModelProperty(notes = "Combo's name")
    private String name;

    @NotNull(message = "Combo description is required")
    @ApiModelProperty(notes = "Combo's description")
    private String description;

    @NotNull(message = "Products id for combo is required")
    @ApiModelProperty(notes = "Combo's products")
    private List<Long> productsIds;
}
