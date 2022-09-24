package com.malimaquintino.erp.catalog.service.combo;

import com.malimaquintino.erp.catalog.exceptions.ComboNotFoundException;
import com.malimaquintino.erp.catalog.models.Combo;
import com.malimaquintino.erp.catalog.repository.ComboRepository;
import com.malimaquintino.erp.catalog.service.product.ProductService;
import com.malimaquintino.erp.commonmslib.dto.combo.ComboInputDto;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.malimaquintino.erp.catalog.responses.ComboResponse.*;
import static com.malimaquintino.erp.commonmslib.dto.common.CommonResponse.convertThrowableToCommonResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class ComboServiceImpl implements ComboService {

    private final ComboRepository comboRepository;
    private final ProductService productService;

    @Override
    public CommonResponse<?> create(ComboInputDto comboInputDto) {
        try {
            var combo = save(comboInputDtoToEntity(comboInputDto));
            return created(combo.toOutputDto());
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public CommonResponse<?> update(Long id, ComboInputDto comboInputDto) {
        try {
            var savedCombo = comboRepository.findById(id).orElseThrow(ComboNotFoundException::new);
            var combo = save(updateCombo(savedCombo, comboInputDto));
            return updated(combo.toOutputDto());
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public Combo save(Combo combo) {
        return comboRepository.save(combo);
    }

    @Override
    public CommonResponse<?> findAll() {
        // todo filter and pagination
        try {
            var combos = comboRepository.findAll();
            return found(combos.stream().map(Combo::toOutputDto).toList());
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public CommonResponse<?> findById(long id) {
        try {
            var savedCombo = findComboById(id);
            return found(savedCombo.toOutputDto());
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public Combo findComboById(long id) {
        return comboRepository.findById(id).orElseThrow(ComboNotFoundException::new);
    }

    @Override
    public Combo comboInputDtoToEntity(ComboInputDto comboInputDto) {
        var products = productService.findByIdIn(comboInputDto.getProductsIds());
        return Combo.builder()
                .name(comboInputDto.getName())
                .description(comboInputDto.getDescription())
                .products(products)
                .build();
    }

    private Combo updateCombo(Combo savedCombo, ComboInputDto comboInputDto) {
        var products = productService.findByIdIn(comboInputDto.getProductsIds());
        savedCombo.setName(comboInputDto.getName());
        savedCombo.setDescription(comboInputDto.getDescription());
        savedCombo.setProducts(products);
        return savedCombo;
    }
}
