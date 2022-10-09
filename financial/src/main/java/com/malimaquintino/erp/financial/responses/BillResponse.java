package com.malimaquintino.erp.financial.responses;

import com.malimaquintino.erp.commonmslib.constant.HttpStatusConstants;
import com.malimaquintino.erp.commonmslib.dto.bill.BillOutputDto;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.List;

@UtilityClass
public class BillResponse {
    public static CommonResponse<?> created(BillOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HTTP_CREATED.CODE)
                .message(HttpStatusConstants.HTTP_CREATED.DESCRIPTION)
                .detailMessage("Created bill id: " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> updated(BillOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Updated bill id: " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> found(List<BillOutputDto> outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Performed find all bills")
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> found(BillOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Found bill " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
