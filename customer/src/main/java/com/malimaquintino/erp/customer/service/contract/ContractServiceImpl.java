package com.malimaquintino.erp.customer.service.contract;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.contract.ContractInputDto;
import com.malimaquintino.erp.commonmslib.dto.product.ProductOutputDto;
import com.malimaquintino.erp.customer.exceptions.ContractNotFoundException;
import com.malimaquintino.erp.customer.models.Contract;
import com.malimaquintino.erp.customer.models.ContractProduct;
import com.malimaquintino.erp.customer.repository.ContractRepository;
import com.malimaquintino.erp.customer.requests.ProductRequest;
import com.malimaquintino.erp.customer.service.address.AddressService;
import com.malimaquintino.erp.customer.service.client.ClientService;
import com.malimaquintino.erp.customer.service.email.EmailService;
import com.malimaquintino.erp.customer.service.phone.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.malimaquintino.erp.commonmslib.dto.common.CommonResponse.convertThrowableToCommonResponse;
import static com.malimaquintino.erp.customer.responses.ContractResponse.created;
import static com.malimaquintino.erp.customer.responses.ContractResponse.found;

@Service
@RequiredArgsConstructor
@Transactional
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    private final ProductRequest productRequest;

    private final AddressService addressService;

    private final PhoneService phoneService;

    private final EmailService emailService;

    private final ClientService clientService;


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
        var contract = Contract.builder().build();
        Set<ContractProduct> products = new HashSet<>();
        contractInputDto.getProducts().forEach(productId -> products.add(toContractProduct(productRequest.findProductById(productId), contract)));

        contract.setAddress(addressService.addressInputDtoToEntity(contractInputDto.getAddress(), contract));
        contract.setClient(clientService.clientInputDtoToEntity(contractInputDto.getClient(), contract));
        contract.setEmails(contractInputDto.getEmails().stream().map(mail -> emailService.emailInputDtoToEntity(mail, contract)).collect(Collectors.toSet()));
        contract.setPhones(contractInputDto.getPhones().stream().map(phone -> phoneService.phoneInputDtoToEntity(phone, contract)).collect(Collectors.toSet()));
        contract.setProducts(products);
        contract.setDueDay(contractInputDto.getDueDay());
        return contract;
    }

    private ContractProduct toContractProduct(ResponseEntity<?> response, Contract contract) {
        CommonResponse commonResponse = (CommonResponse) response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        ProductOutputDto productOutputDto = objectMapper.convertValue(commonResponse.getResult(), ProductOutputDto.class);
        return ContractProduct.builder()
                .contract(contract)
                .productId(productOutputDto.getId())
                .productName(productOutputDto.getName())
                .productDesc(productOutputDto.getDescription())
                .build();
    }
}
