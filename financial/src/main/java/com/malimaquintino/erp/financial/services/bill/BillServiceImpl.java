package com.malimaquintino.erp.financial.services.bill;

import com.malimaquintino.erp.commonmslib.dto.bill.BillInputDto;
import com.malimaquintino.erp.commonmslib.dto.bill.BillProductInputDto;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.financial.models.Bill;
import com.malimaquintino.erp.financial.models.BillProduct;
import com.malimaquintino.erp.financial.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

import static com.malimaquintino.erp.commonmslib.dto.common.CommonResponse.convertThrowableToCommonResponse;
import static com.malimaquintino.erp.financial.responses.BillResponse.created;

@Service
@RequiredArgsConstructor
@Transactional
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

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
}
