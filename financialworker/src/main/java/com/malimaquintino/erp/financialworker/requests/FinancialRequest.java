package com.malimaquintino.erp.financialworker.requests;

import com.malimaquintino.erp.commonmslib.dto.bill.BillInputDtoV2;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "financial-ms")
public interface FinancialRequest {

    @PostMapping(path = "/v1/bill/from-worker", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommonResponse> postBill(@RequestBody BillInputDtoV2 inputDto);
}
