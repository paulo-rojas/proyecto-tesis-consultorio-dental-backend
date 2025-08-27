package com.proyecto.consultorio_dental_backend.exception;

public class DepartamentoException extends Exception {

    public DepartamentoException() {
    }

    public DepartamentoException(String message) {
        super(message);
    }

    public DepartamentoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartamentoException(Throwable cause) {
        super(cause);
    }

    public DepartamentoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
