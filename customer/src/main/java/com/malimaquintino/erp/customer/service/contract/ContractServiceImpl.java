package com.malimaquintino.erp.customer.service.contract;

import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.contract.ContractInputDto;
import com.malimaquintino.erp.customer.models.Contract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
    @Override
    public CommonResponse<?> create(ContractInputDto contractInputDto) {
        return null;
    }

    @Override
    public CommonResponse<?> update(Long id, ContractInputDto contractInputDto) {
        return null;
    }

    @Override
    public Contract save(Contract contract) {
        return null;
    }

    @Override
    public CommonResponse<?> findAll() {
        return null;
    }

    @Override
    public CommonResponse<?> findById(long id) {
        return null;
    }

    @Override
    public Contract findContractById(long id) {
        return null;
    }

    @Override
    public Contract contractInputDtoToEntity(ContractInputDto contractInputDto) {
        return null;
    }
}
