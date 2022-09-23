package com.malimaquintino.erp.commonmslib.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.malimaquintino.erp.commonmslib.constant.HttpStatusConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {

    private int status;
    private Boolean error;
    private String message;
    private String detailMessage;
    private LocalDateTime timestamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    public CommonResponse(T result, int status, Boolean error, String message, String detailMessage) {
        this.result = result;
        this.status = status;
        this.error = error;
        this.message = message;
        this.detailMessage = detailMessage;
        this.timestamp = LocalDateTime.now();
    }

    public static CommonResponse<?> convertThrowableToCommonResponse(Throwable e) {
        e.printStackTrace();
        return CommonResponse.builder()
                .status(getStatusFromException(e))
                .error(Boolean.TRUE)
                .message(e.getMessage())
                .detailMessage(getDetailMessageFromException(e))
                .timestamp(LocalDateTime.now())
                .build();
    }

    private static int getStatusFromException(Throwable e) {
        try {
            return (int) ((Object) e).getClass().getField("status").get(e);
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            return HttpStatusConstants.HttpBadRequest.CODE;
        }
    }

    private static String getDetailMessageFromException(Throwable e) {
        try {
            return (String) ((Object) e).getClass().getField("detailMessage").get(e);
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            return HttpStatusConstants.HttpBadRequest.DESCRIPTION;
        }
    }

    public static CommonResponse<?> ok() {
        return CommonResponse.builder()
                .result("ok")
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HTTP_CREATED.CODE)
                .message(HttpStatusConstants.HTTP_CREATED.DESCRIPTION)
                .detailMessage("received command ok" )
                .timestamp(LocalDateTime.now()).build();
    }

    public static CommonResponse<?> created(Object object) {
        return CommonResponse.builder()
                .result(object)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HTTP_CREATED.CODE)
                .message(HttpStatusConstants.HTTP_CREATED.DESCRIPTION)
                .detailMessage("Created" )
                .timestamp(LocalDateTime.now()).build();
    }

    public static CommonResponse<?> updated(Object object) {
        return CommonResponse.builder()
                .result(object)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Updated")
                .timestamp(LocalDateTime.now()).build();
    }

    public static CommonResponse<?> founded(Object object) {
        return CommonResponse.builder()
                .result(object)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Query performed successfully!")
                .timestamp(LocalDateTime.now()).build();
    }
}
