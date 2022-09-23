package com.malimaquintino.erp.catalog.service.product;

import com.malimaquintino.erp.catalog.models.Product;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.product.ProductInputDto;

public interface ProductService {
    CommonResponse<?> create(ProductInputDto productInputDto);

    CommonResponse<?> update(Long id, ProductInputDto productInputDto);

    Product save(Product productType);

    CommonResponse<?> findAll();

    CommonResponse<?> findById(long id);

    Product findProductById(long id);

    Product productInputDtoToEntity(ProductInputDto productInputDto);
}
