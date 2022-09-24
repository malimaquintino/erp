package com.malimaquintino.erp.catalog.responses;

import com.malimaquintino.erp.commonmslib.constant.HttpStatusConstants;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.product.ProductOutputDto;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.List;


@UtilityClass
public class ProductResponse {
    public static CommonResponse<?> created(ProductOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HTTP_CREATED.CODE)
                .message(HttpStatusConstants.HTTP_CREATED.DESCRIPTION)
                .detailMessage("Created product id: " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> updated(ProductOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Updated product id: " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> found(List<ProductOutputDto> outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Performed find all products")
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> found(ProductOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Found product " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
