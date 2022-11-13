package com.malimaquintino.erp.financial.requests;

import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "customer-ms")
public interface CustomerRequest {

    @GetMapping(path = "/v1/contract/{id}/products", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommonResponse> findContractProducts(@PathVariable long id);
}
