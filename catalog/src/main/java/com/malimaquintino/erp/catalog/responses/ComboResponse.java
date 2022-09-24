package com.malimaquintino.erp.catalog.responses;

import com.malimaquintino.erp.commonmslib.constant.HttpStatusConstants;
import com.malimaquintino.erp.commonmslib.dto.combo.ComboOutputDto;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.List;


@UtilityClass
public class ComboResponse {
    public static CommonResponse<?> created(ComboOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HTTP_CREATED.CODE)
                .message(HttpStatusConstants.HTTP_CREATED.DESCRIPTION)
                .detailMessage("Created combo id: " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> updated(ComboOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Updated combo id: " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> found(List<ComboOutputDto> outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Performed find all combos")
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> found(ComboOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Found combo " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
