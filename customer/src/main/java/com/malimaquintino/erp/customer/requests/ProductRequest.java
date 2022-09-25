package com.malimaquintino.erp.customer.requests;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "product")
public interface ProductRequest {

    @GetMapping(path = "/v1/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> findProductById(@PathVariable long id);
}
