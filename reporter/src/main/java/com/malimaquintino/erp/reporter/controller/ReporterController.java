package com.malimaquintino.erp.reporter.controller;

import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.report.ReportInputDto;
import com.malimaquintino.erp.reporter.services.freequery.FreeQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/report")
public class ReporterController {

    private final FreeQueryService freeQueryService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> executeQuery(@Valid @RequestBody ReportInputDto inputDto) {
        log.info("Creating new report {}", inputDto);
        CommonResponse<?> commonResponse = freeQueryService.getQueryData(inputDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @PostMapping(value = "/file", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> generateFile(@Valid @RequestBody ReportInputDto inputDto) {
        log.info("Creating new report {}", inputDto);
        CommonResponse<?> commonResponse = freeQueryService.generateFile(inputDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

}
