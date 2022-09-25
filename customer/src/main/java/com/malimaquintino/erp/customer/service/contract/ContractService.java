package com.malimaquintino.erp.customer.service.contract;

import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.contract.ContractInputDto;
import com.malimaquintino.erp.customer.models.Contract;

public interface ContractService {
    CommonResponse<?> create(ContractInputDto contractInputDto);

    CommonResponse<?> update(Long id, ContractInputDto contractInputDto);

    Contract save(Contract contract);

    CommonResponse<?> findAll();

    CommonResponse<?> findById(long id);

    Contract findContractById(long id);

    Contract contractInputDtoToEntity(ContractInputDto contractInputDto);
}
