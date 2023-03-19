package com.malimaquintino.erp.commonmslib.enums;

public enum BillStatus {
    OPEN("OPEN"),
    PAYED("PAYED"),
    CANCELED("CANCELED");

    private final String status;

    BillStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
