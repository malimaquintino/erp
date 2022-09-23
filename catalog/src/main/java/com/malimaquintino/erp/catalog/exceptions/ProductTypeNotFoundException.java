package com.malimaquintino.erp.catalog.exceptions;

import com.malimaquintino.erp.commonmslib.constant.HttpStatusConstants;

public class ProductTypeNotFoundException extends RuntimeException {
    public final int status;
    public final String detailMessage;

    public ProductTypeNotFoundException() {
        super("Product Type not found!");
        this.status = HttpStatusConstants.HTTP_NOT_FOUND.CODE;
        this.detailMessage = HttpStatusConstants.HTTP_NOT_FOUND.DESCRIPTION;
    }
}
