package com.goodchalk.goodpass.exception;

import lombok.NoArgsConstructor;

public class GoodPassSystemException extends RuntimeException{
    public GoodPassSystemException() {
    }

    public GoodPassSystemException(String message) {
        super(message);
    }

    public GoodPassSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodPassSystemException(Throwable cause) {
        super(cause);
    }

    public GoodPassSystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
