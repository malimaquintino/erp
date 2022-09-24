package com.malimaquintino.erp.catalog.service.product;

import com.malimaquintino.erp.catalog.models.Product;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.product.ProductInputDto;

import java.util.List;
import java.util.Set;

public interface ProductService {
    CommonResponse<?> create(ProductInputDto productInputDto);

    CommonResponse<?> update(Long id, ProductInputDto productInputDto);

    Product save(Product product);

    CommonResponse<?> findAll();

    CommonResponse<?> findById(long id);

    Product findProductById(long id);

    Set<Product> findByIdIn(List<Long> productIdList);

    Product productInputDtoToEntity(ProductInputDto productInputDto);
}
