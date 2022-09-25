package com.malimaquintino.erp.commonmslib.enums;

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
