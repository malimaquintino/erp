package com.malimaquintino.erp.fakergenerator.requests;

import com.malimaquintino.erp.commonmslib.dto.combo.ComboInputDto;
import com.malimaquintino.erp.commonmslib.dto.product.ProductInputDto;
import com.malimaquintino.erp.commonmslib.dto.producttype.ProductTypeInputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(value = "catalog-ms")
public interface CatalogRequest {

    @PostMapping(path = "/v1/product-type", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> createType(@Valid @RequestBody ProductTypeInputDto inputDTO);

    @PostMapping(path = "/v1/product", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> createProduct(@Valid @RequestBody ProductInputDto inputDTO);

    @PostMapping(path = "/v1/combo", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> createCombo(@Valid @RequestBody ComboInputDto inputDTO);
}
