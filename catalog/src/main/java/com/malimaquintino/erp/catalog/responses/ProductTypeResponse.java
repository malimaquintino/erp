package com.malimaquintino.erp.catalog.responses;

import com.malimaquintino.erp.commonmslib.constant.HttpStatusConstants;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.producttype.ProductTypeOutputDto;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.List;


@UtilityClass
public class ProductTypeResponse {
    public static CommonResponse<?> created(ProductTypeOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HTTP_CREATED.CODE)
                .message(HttpStatusConstants.HTTP_CREATED.DESCRIPTION)
                .detailMessage("Created product type id: " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> updated(ProductTypeOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Updated product type id: " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> found(List<ProductTypeOutputDto> outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Performed find all product type")
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> found(ProductTypeOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Found product type id " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
