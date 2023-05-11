package com.malimaquintino.erp.gateway.exception;

public class JwtTokenMalFormedException extends RuntimeException {
    public JwtTokenMalFormedException(String msg) {
        super(msg);
    }
}
