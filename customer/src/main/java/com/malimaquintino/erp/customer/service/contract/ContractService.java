package com.malimaquintino.erp.customer.service.contract;

import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.contract.ContractFilterInputDto;
import com.malimaquintino.erp.commonmslib.dto.contract.ContractInputDto;
import com.malimaquintino.erp.customer.models.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    CommonResponse<?> create(ContractInputDto contractInputDto);

    CommonResponse<?> update(Long id, ContractInputDto contractInputDto);

    Contract save(Contract contract);

    CommonResponse<?> findAll(ContractFilterInputDto inputDto, Pageable pageable);

    Page<Contract> findByFilter(ContractFilterInputDto findByFilter, Pageable pageable);

    CommonResponse<?> findById(long id);

    Contract findContractById(long id);

    Contract contractInputDtoToEntity(ContractInputDto contractInputDto);

    CommonResponse<?> findContractProducts(long id);
}
