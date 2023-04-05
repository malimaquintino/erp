package com.malimaquintino.erp.reporter.services.freequery;

import com.malimaquintino.erp.commonmslib.dto.report.ReportInputDto;

public interface FreeQueryService {

    void executeQuery(ReportInputDto inputDto);
}
