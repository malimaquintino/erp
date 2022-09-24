package com.malimaquintino.erp.catalog.controllers.v1;

import com.malimaquintino.erp.catalog.service.combo.ComboService;
import com.malimaquintino.erp.commonmslib.dto.combo.ComboInputDto;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/combo")
public class ComboController {

    private final ComboService comboService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody ComboInputDto inputDto) {
        log.info("Creating new combo {}", inputDto);
        CommonResponse<?> commonResponse = comboService.create(inputDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable long id, @Valid @RequestBody ComboInputDto inputDto) {
        log.info("Updating combo id {}", id);
        CommonResponse<?> commonResponse = comboService.update(id, inputDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        log.info("Finding all combo");
        CommonResponse<?> commonResponse = comboService.findAll();
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable long id) {
        log.info("Finding combo {}", id);
        CommonResponse<?> commonResponse = comboService.findById(id);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }
}
