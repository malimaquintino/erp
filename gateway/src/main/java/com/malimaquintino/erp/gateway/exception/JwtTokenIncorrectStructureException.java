package com.malimaquintino.erp.gateway.exception;

public class JwtTokenIncorrectStructureException extends RuntimeException {
    public JwtTokenIncorrectStructureException(String msg) {
        super(msg);
    }
}
