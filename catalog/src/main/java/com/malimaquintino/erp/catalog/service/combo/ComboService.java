package com.malimaquintino.erp.catalog.service.combo;

import com.malimaquintino.erp.catalog.models.Combo;
import com.malimaquintino.erp.commonmslib.dto.combo.ComboInputDto;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;

public interface ComboService {
    CommonResponse<?> create(ComboInputDto comboInputDto);

    CommonResponse<?> update(Long id, ComboInputDto productInputDto);

    Combo save(Combo productType);

    CommonResponse<?> findAll();

    CommonResponse<?> findById(long id);

    Combo findComboById(long id);

    Combo comboInputDtoToEntity(ComboInputDto productInputDto);
}
