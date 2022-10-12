package com.malimaquintino.erp.fakergenerator.mocks;

import com.malimaquintino.erp.commonmslib.dto.producttype.ProductTypeInputDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CatalogMock {

    public static ProductTypeInputDto getProductType(String name){
        return ProductTypeInputDto.builder()
                .name(name)
                .active(Boolean.TRUE)
                .build();
    }
}
