package com.malimaquintino.erp.commonmslib.enums;

public enum BillPaymentMethod {

    MONEY("MONEY"),
    BANK_SLIP("BANK_SLIP"),
    PIX("PIX"),
    CREDIT_CARD("CREDIT_CARD"),
    DEBIT_CARD("DEBIT_CARD");

    private final String method;

    BillPaymentMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return method;
    }
}