package com.malimaquintino.erp.catalog.service.producttype;


import com.malimaquintino.erp.catalog.models.ProductType;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.producttype.ProductTypeInputDto;

public interface ProductTypeService {
    CommonResponse<?> create(ProductTypeInputDto productTypeInputDto);

    CommonResponse<?> update(Long id, ProductTypeInputDto productTypeInputDto);

    ProductType save(ProductType productType);

    CommonResponse<?> findAll();

    CommonResponse<?> findById(long id);

    ProductType findAuthorById(long id);

    ProductType productTypeInputDtoToEntity(ProductTypeInputDto authorInputDto);
}
