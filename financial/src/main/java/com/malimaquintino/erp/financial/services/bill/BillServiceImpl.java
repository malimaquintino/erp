package com.malimaquintino.erp.financial.services.bill;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.malimaquintino.erp.commonmslib.dto.bill.BillInputDto;
import com.malimaquintino.erp.commonmslib.dto.bill.BillInputDtoV2;
import com.malimaquintino.erp.commonmslib.dto.bill.BillProductInputDto;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.contract.ContractProductOutputDto;
import com.malimaquintino.erp.financial.models.Bill;
import com.malimaquintino.erp.financial.models.BillProduct;
import com.malimaquintino.erp.financial.repository.BillRepository;
import com.malimaquintino.erp.financial.requests.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.malimaquintino.erp.commonmslib.dto.common.CommonResponse.convertThrowableToCommonResponse;
import static com.malimaquintino.erp.commonmslib.util.DateUtils.nextDateFromDay;
import static com.malimaquintino.erp.financial.responses.BillResponse.created;

@Service
@RequiredArgsConstructor
@Transactional
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    private final CustomerRequest customerRequest;

    @Override
    public CommonResponse<?> createCustomerBill(BillInputDto billInputDto) {
        try {
            var bill = save(billInputDtoToEntity(billInputDto));
            return created(bill.toOutputDto());
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill billInputDtoToEntity(BillInputDto inputDto) {
        var bill = Bill.builder()
                .total(inputDto.getTotal())
                .dueDate(inputDto.getDueDate())
                .customerId(inputDto.getCustomerId())
                .customerName(inputDto.getCustomerName())
                .customerDocument(inputDto.getCustomerDocument())
                .build();
        bill.setBillProductList(inputDto.getBillProducts().stream()
                .map(prodInputDto -> billProductToEntity(prodInputDto, bill))
                .collect(Collectors.toSet())
        );
        return bill;
    }

    @Override
    public CommonResponse<?> createCustomerBillFromWorker(BillInputDtoV2 inputDto) {
        try {
            ResponseEntity<?> response = customerRequest.findContractProducts(inputDto.getContractId());
            CommonResponse commonResponse = (CommonResponse) response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            List<ContractProductOutputDto> products = objectMapper.convertValue(commonResponse.getResult(), objectMapper.getTypeFactory().constructCollectionType(List.class, ContractProductOutputDto.class));

            var billInputDto = BillInputDto.builder()
                    .billProducts(products.stream().map(this::toBillProductInputDto).collect(Collectors.toSet()))
                    .customerId(inputDto.getCustomerId())
                    .customerDocument(inputDto.getCustomerDocument())
                    .customerName(inputDto.getCustomerName())
                    .dueDate(nextDateFromDay(inputDto.getDueDay()))
                    .total(inputDto.getTotal())
                    .build();

            var bill = save(billInputDtoToEntity(billInputDto));
            return created(bill.toOutputDto());

        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    private BillProduct billProductToEntity(BillProductInputDto inputDto, Bill bill) {
        return BillProduct.builder()
                .bill(bill)
                .productId(inputDto.getProductId())
                .productName(inputDto.getProductName())
                .productDescription(inputDto.getProductDescription())
                .productType(inputDto.getProductType())
                .productPrice(inputDto.getProductPrice())
                .build();
    }

    private BillProductInputDto toBillProductInputDto(ContractProductOutputDto contractProductOutputDto) {
        return BillProductInputDto
                .builder()
                .productDescription(contractProductOutputDto.getProductDesc())
                .productId(contractProductOutputDto.getProductId())
                .productName(contractProductOutputDto.getProductName())
                .productPrice(contractProductOutputDto.getValue())
                .productType("TODO")
                .build();
    }
}
