package com.malimaquintino.erp.customer.models;

public enum PersonType {
    PF("PF"),
    PJ("PJ");

    private final String type;

    PersonType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
