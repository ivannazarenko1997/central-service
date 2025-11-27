package com.mycompany.demo.warehouse.exception;


public class CentralServiceException extends RuntimeException {
    public CentralServiceException() {
        super();
    }

    public CentralServiceException(String message) {
        super(message);
    }

    public CentralServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CentralServiceException(Throwable cause) {
        super(cause);
    }

    protected CentralServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
