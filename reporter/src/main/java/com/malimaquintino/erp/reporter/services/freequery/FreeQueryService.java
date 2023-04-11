package com.malimaquintino.erp.reporter.services.freequery;

import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.report.ReportInputDto;

public interface FreeQueryService {

    CommonResponse<?> executeQuery(ReportInputDto inputDto);
}
