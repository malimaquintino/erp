package com.malimaquintino.erp.reporter.exceptions;

import com.malimaquintino.erp.commonmslib.constant.HttpStatusConstants;

public class BadFormatQueryException extends RuntimeException {
    public final int status;
    public final String detailMessage;

    public BadFormatQueryException() {
        super("Bad Format Query!");
        this.status = HttpStatusConstants.HTTP_NOT_ACCEPTABLE.CODE;
        this.detailMessage = HttpStatusConstants.HTTP_NOT_ACCEPTABLE.DESCRIPTION;
    }
}
