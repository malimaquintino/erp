package com.malimaquintino.erp.customer.responses;

import com.malimaquintino.erp.commonmslib.constant.HttpStatusConstants;
import com.malimaquintino.erp.commonmslib.dto.client.ClientOutputDto;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.List;

@UtilityClass
public class ClientResponse {
    public static CommonResponse<?> created(ClientOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HTTP_CREATED.CODE)
                .message(HttpStatusConstants.HTTP_CREATED.DESCRIPTION)
                .detailMessage("Created client id: " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> updated(ClientOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Updated client id: " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> found(List<ClientOutputDto> outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Performed find all clients")
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static CommonResponse<?> found(ClientOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Found client " + outputDto.getId())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
