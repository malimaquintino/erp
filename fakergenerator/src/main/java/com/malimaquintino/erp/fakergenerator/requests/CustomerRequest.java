package com.malimaquintino.erp.fakergenerator.requests;

import com.malimaquintino.erp.commonmslib.dto.contract.ContractInputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(value = "customer-ms")
public interface CustomerRequest {

    @PostMapping(path = "/v1/contract", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> createContract(@Valid @RequestBody ContractInputDto inputDTO);

}
