package com.malimaquintino.erp.customer.exceptions;

import com.malimaquintino.erp.commonmslib.constant.HttpStatusConstants;

public class ContractProductNotFoundException extends RuntimeException {
    public final int status;
    public final String detailMessage;

    public ContractProductNotFoundException() {
        super("Contract product not found!");
        this.status = HttpStatusConstants.HTTP_NOT_FOUND.CODE;
        this.detailMessage = HttpStatusConstants.HTTP_NOT_FOUND.DESCRIPTION;
    }
}
