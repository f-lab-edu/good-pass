package com.goodchalk.goodpass.exception;



public class GoodPassBusinessException extends RuntimeException {
    public GoodPassBusinessException() {
    }

    public GoodPassBusinessException(String message) {
        super(message);
    }

    public GoodPassBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodPassBusinessException(Throwable cause) {
        super(cause);
    }

    public GoodPassBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
