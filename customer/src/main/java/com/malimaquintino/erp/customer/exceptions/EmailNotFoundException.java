package com.malimaquintino.erp.customer.exceptions;

import com.malimaquintino.erp.commonmslib.constant.HttpStatusConstants;

public class EmailNotFoundException extends RuntimeException {
    public final int status;
    public final String detailMessage;

    public EmailNotFoundException() {
        super("Email not found!");
        this.status = HttpStatusConstants.HTTP_NOT_FOUND.CODE;
        this.detailMessage = HttpStatusConstants.HTTP_NOT_FOUND.DESCRIPTION;
    }
}
