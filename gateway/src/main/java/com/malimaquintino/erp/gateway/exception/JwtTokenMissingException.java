package com.malimaquintino.erp.gateway.exception;

public class JwtTokenMissingException extends RuntimeException {
    public JwtTokenMissingException(String msg) {
        super(msg);
    }
}
