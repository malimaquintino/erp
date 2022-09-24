package com.malimaquintino.erp.catalog.service.product;

import com.malimaquintino.erp.catalog.exceptions.ProductNotFoundException;
import com.malimaquintino.erp.catalog.models.Product;
import com.malimaquintino.erp.catalog.repositories.ProductRepository;
import com.malimaquintino.erp.catalog.service.producttype.ProductTypeService;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.product.ProductInputDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.malimaquintino.erp.catalog.responses.ProductResponse.*;
import static com.malimaquintino.erp.commonmslib.dto.common.CommonResponse.convertThrowableToCommonResponse;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductTypeService productTypeService;

    @Override
    public CommonResponse<?> create(ProductInputDto productInputDto) {
        try {
            var product = save(productInputDtoToEntity(productInputDto));
            return created(product.toOutputDto());
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public CommonResponse<?> update(Long id, ProductInputDto productInputDto) {
        try {
            var savedProduct = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
            var product = save(updateProduct(savedProduct, productInputDto));
            return updated(product.toOutputDto());
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public CommonResponse<?> findAll() {
        // todo filter and pagination
        try {
            var products = productRepository.findAll();
            var productOutputDtoList = products.stream().map(Product::toOutputDto).toList();
            return found(productOutputDtoList);
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public CommonResponse<?> findById(long id) {
        try {
            var savedProduct = findProductById(id);
            return found(savedProduct.toOutputDto());
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public Product findProductById(long id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Set<Product> findByIdIn(List<Long> productIdList) {
        return productRepository.findByIdIn(productIdList);
    }

    @Override
    public Product productInputDtoToEntity(ProductInputDto productInputDto) {
        var productType = productTypeService.findProductTypeById(productInputDto.getProductTypeId());
        return Product.builder()
                .name(productInputDto.getName())
                .description(productInputDto.getDescription())
                .price(productInputDto.getPrice())
                .productType(productType)
                .build();
    }

    private Product updateProduct(Product savedProduct, ProductInputDto productInputDto) {
        var productType = productTypeService.findProductTypeById(productInputDto.getProductTypeId());
        savedProduct.setName(productInputDto.getName());
        savedProduct.setDescription(productInputDto.getDescription());
        savedProduct.setPrice(productInputDto.getPrice());
        savedProduct.setProductType(productType);
        return savedProduct;
    }
}
