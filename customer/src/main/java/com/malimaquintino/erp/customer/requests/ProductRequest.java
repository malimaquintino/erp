package com.malimaquintino.erp.customer.requests;

import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "catalog-ms")
public interface ProductRequest {

    @GetMapping(path = "/v1/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommonResponse> findProductById(@PathVariable long id);
}
