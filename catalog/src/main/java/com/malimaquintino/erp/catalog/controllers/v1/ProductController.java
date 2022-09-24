package com.malimaquintino.erp.catalog.controllers.v1;

import com.malimaquintino.erp.catalog.service.product.ProductService;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.product.ProductInputDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody ProductInputDto inputDto) {
        log.info("Creating new product {}", inputDto);
        CommonResponse<?> commonResponse = productService.create(inputDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable long id, @Valid @RequestBody ProductInputDto inputDto) {
        log.info("Updating product id {}", id);
        CommonResponse<?> commonResponse = productService.update(id, inputDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        log.info("Finding all products");
        CommonResponse<?> commonResponse = productService.findAll();
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable long id) {
        log.info("Finding product {}", id);
        CommonResponse<?> commonResponse = productService.findById(id);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }
}
