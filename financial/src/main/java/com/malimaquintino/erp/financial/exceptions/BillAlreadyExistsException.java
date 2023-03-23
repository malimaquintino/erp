package com.malimaquintino.erp.financial.exceptions;

public class BillAlreadyExistsException extends RuntimeException {
    public BillAlreadyExistsException() {
        super("There is already a bill created for this customer with this due date");
    }
}
