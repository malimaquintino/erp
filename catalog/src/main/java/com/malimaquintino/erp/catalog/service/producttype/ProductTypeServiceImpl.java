package com.malimaquintino.erp.catalog.service.producttype;

import com.malimaquintino.erp.catalog.exceptions.ProductTypeNotFoundException;
import com.malimaquintino.erp.catalog.models.ProductType;
import com.malimaquintino.erp.catalog.repository.ProductTypeRepository;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.producttype.ProductTypeInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.malimaquintino.erp.catalog.responses.ProductTypeResponse.*;
import static com.malimaquintino.erp.commonmslib.dto.common.CommonResponse.convertThrowableToCommonResponse;

@Service
@RequiredArgsConstructor
public class ProductTypeServiceImpl implements ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    @Override
    public CommonResponse<?> create(ProductTypeInputDto productTypeInputDto) {
        try {
            var productType = save(productTypeInputDtoToEntity(productTypeInputDto));
            return created(productType.toOutputDto());
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public CommonResponse<?> update(Long id, ProductTypeInputDto productTypeInputDto) {
        try {
            var savedProductType = productTypeRepository.findById(id).orElseThrow(ProductTypeNotFoundException::new);
            var productType = save(updateProductType(savedProductType, productTypeInputDto));
            return updated(productType.toOutputDto());
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public ProductType save(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Override
    public CommonResponse<?> findAll() {
        // todo filter and pagination
        try {
            var productTypes = productTypeRepository.findAll();
            var productTypeOutputDtoList = productTypes.stream().map(ProductType::toOutputDto).toList();
            return found(productTypeOutputDtoList);
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public CommonResponse<?> findById(long id) {
        try {
            var savedProductType = findProductTypeById(id);
            return found(savedProductType.toOutputDto());
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public ProductType findProductTypeById(long id) {
        return productTypeRepository.findById(id).orElseThrow(ProductTypeNotFoundException::new);
    }

    @Override
    public ProductType productTypeInputDtoToEntity(ProductTypeInputDto productTypeInputDto) {
        return ProductType.builder()
                .name(productTypeInputDto.getName())
                .active(productTypeInputDto.getActive())
                .build();
    }

    private ProductType updateProductType(ProductType productType, ProductTypeInputDto productTypeInputDto) {
        productType.setName(productTypeInputDto.getName());
        productType.setActive(productTypeInputDto.getActive());
        return productType;
    }
}
