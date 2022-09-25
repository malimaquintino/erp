package com.malimaquintino.erp.customer.service.contract;

import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.contract.ContractInputDto;
import com.malimaquintino.erp.commonmslib.dto.product.ProductOutputDto;
import com.malimaquintino.erp.customer.exceptions.ContractNotFoundException;
import com.malimaquintino.erp.customer.models.Contract;
import com.malimaquintino.erp.customer.models.ContractProduct;
import com.malimaquintino.erp.customer.repository.ContractRepository;
import com.malimaquintino.erp.customer.requests.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.malimaquintino.erp.commonmslib.dto.common.CommonResponse.convertThrowableToCommonResponse;
import static com.malimaquintino.erp.customer.responses.ContractResponse.created;
import static com.malimaquintino.erp.customer.responses.ContractResponse.found;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    private final ProductRequest productRequest;


    @Override
    public CommonResponse<?> create(ContractInputDto contractInputDto) {
        try {
            var contract = save(contractInputDtoToEntity(contractInputDto));
            return created(contract.toOutputDto());
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public CommonResponse<?> update(Long id, ContractInputDto contractInputDto) {
        return null;
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public CommonResponse<?> findAll() {
        // todo filter and pagination
        try {
            var savedContracts = contractRepository.findAll();
            return found(savedContracts.stream().map(Contract::toOutputDto).toList());
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public CommonResponse<?> findById(long id) {
        try {
            var savedContract = findContractById(id);
            return found(savedContract.toOutputDto());
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public Contract findContractById(long id) {
        return contractRepository.findById(id).orElseThrow(ContractNotFoundException::new);
    }

    @Override
    public Contract contractInputDtoToEntity(ContractInputDto contractInputDto) {
        List<ContractProduct> products = new ArrayList<>();
        contractInputDto.getProducts().forEach(productId -> {
            products.add(toContractProduct(productRequest.findProductById(productId)));
        });
        return null;
    }

    private ContractProduct toContractProduct(ResponseEntity<?> response) {
        var productOutputDto = response.getBody();
        return ContractProduct.builder()
//                .contract(null) //todo
//                .productId(productOutputDto.getId())
//                .productName(productOutputDto.getName())
//                .productDesc(productOutputDto.getDescription())
                .build();
    }

}
