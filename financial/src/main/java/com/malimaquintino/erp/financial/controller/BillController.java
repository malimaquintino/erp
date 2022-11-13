package com.malimaquintino.erp.financial.controller;

import com.malimaquintino.erp.commonmslib.dto.bill.BillInputDto;
import com.malimaquintino.erp.commonmslib.dto.bill.BillInputDtoV2;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.financial.services.bill.BillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/bill")
public class BillController {

    private final BillService billService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody BillInputDto inputDto) {
        log.info("Creating new bill {}", inputDto);
        CommonResponse<?> commonResponse = billService.createCustomerBill(inputDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @PostMapping(value = "/from-worker" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createFromWorker(@Valid @RequestBody BillInputDtoV2 inputDto) {
        log.info("Creating new bill {}", inputDto);
        CommonResponse<?> commonResponse = billService.createCustomerBillFromWorker(inputDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }
}
