package com.malimaquintino.erp.financial.services.bill;

import com.malimaquintino.erp.financial.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService{

    private final BillRepository billRepository;

    @Override
    public void createCustomerBill() {

    }
}
