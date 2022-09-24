package com.malimaquintino.erp.catalog.controllers.v1;

import com.malimaquintino.erp.catalog.service.producttype.ProductTypeService;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.producttype.ProductTypeInputDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product-type")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody ProductTypeInputDto inputDto) {
        log.info("Creating new product type {}", inputDto);
        CommonResponse<?> commonResponse = productTypeService.create(inputDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable long id, @Valid @RequestBody ProductTypeInputDto inputDto) {
        log.info("Updating product type id {}", id);
        CommonResponse<?> commonResponse = productTypeService.update(id, inputDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        log.info("Finding all product types");
        CommonResponse<?> commonResponse = productTypeService.findAll();
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable long id) {
        log.info("Finding product type {}", id);
        CommonResponse<?> commonResponse = productTypeService.findById(id);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }
}
