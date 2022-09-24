package com.malimaquintino.erp.customer.exceptions;


import com.malimaquintino.erp.commonmslib.constant.HttpStatusConstants;

public class UnexpectedException extends RuntimeException {

    public final int status;
    public final String detailMessage;

    public UnexpectedException(String message) {
        super(message);
        this.status = HttpStatusConstants.HttpBadRequest.CODE;
        this.detailMessage = HttpStatusConstants.HttpBadRequest.DESCRIPTION;
    }
}
