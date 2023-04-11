package com.malimaquintino.erp.reporter.responses;

import com.malimaquintino.erp.commonmslib.constant.HttpStatusConstants;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@UtilityClass
public class ReportResponse {
    public static CommonResponse<?> found(List<Map<String, String>> output){
        return CommonResponse.builder()
                .result(output)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Performed report query successfully")
                .timestamp(LocalDateTime.now())
                .build();
    }
}
