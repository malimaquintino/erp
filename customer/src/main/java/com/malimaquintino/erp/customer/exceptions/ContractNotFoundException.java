package com.malimaquintino.erp.customer.exceptions;

import com.malimaquintino.erp.commonmslib.constant.HttpStatusConstants;

public class ContractNotFoundException extends RuntimeException {
    public final int status;
    public final String detailMessage;

    public ContractNotFoundException() {
        super("Contract not found!");
        this.status = HttpStatusConstants.HTTP_NOT_FOUND.CODE;
        this.detailMessage = HttpStatusConstants.HTTP_NOT_FOUND.DESCRIPTION;
    }
}
