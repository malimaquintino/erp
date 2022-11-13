package com.malimaquintino.erp.customer.controllers.v1;

import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.contract.ContractFilterInputDto;
import com.malimaquintino.erp.commonmslib.dto.contract.ContractInputDto;
import com.malimaquintino.erp.customer.service.contract.ContractService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.data.domain.Sort.Direction.ASC;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/contract")
public class ContractController {
    private final ContractService contractService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody ContractInputDto inputDto) {
        log.info("Creating new contract {}", inputDto);
        CommonResponse<?> commonResponse = contractService.create(inputDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable long id, @Valid @RequestBody ContractInputDto inputDto) {
        log.info("Updating contract id {}", id);
        CommonResponse<?> commonResponse = contractService.update(id, inputDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll(@SpringQueryMap ContractFilterInputDto inputDto,
                                     @PageableDefault(sort = {"id"}, direction = ASC) Pageable pageable) {
        log.info("Finding all contracts");
        CommonResponse<?> commonResponse = contractService.findAll(inputDto, pageable);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable long id) {
        log.info("Finding contract {}", id);
        CommonResponse<?> commonResponse = contractService.findById(id);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @GetMapping(path = "/{id}/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findContractProducts(@PathVariable long id) {
        log.info("Finding contract products {}", id);
        CommonResponse<?> commonResponse = contractService.findContractProducts(id);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }
}
