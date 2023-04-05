package com.malimaquintino.erp.commonmslib.dto.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportInputDto {
    private boolean file;
    private String query;
}
