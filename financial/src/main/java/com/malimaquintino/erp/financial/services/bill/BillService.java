package com.malimaquintino.erp.financial.services.bill;

import com.malimaquintino.erp.commonmslib.dto.bill.BillInputDto;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.financial.models.Bill;

public interface BillService {

    CommonResponse<?> createCustomerBill(BillInputDto billInputDto);

    Bill save(Bill bill);

    Bill billInputDtoToEntity(BillInputDto inputDto);
}
