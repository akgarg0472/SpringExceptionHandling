package com.akgarg.springexceptionhandling.exception;

import java.time.ZonedDateTime;

@SuppressWarnings("unused")
public class ApiException {

    private final String errorMessage;
    private final Throwable errorCause;
    private final int errorCode;
    private final ZonedDateTime timestamp;

    public ApiException(String errorMessage, Throwable errorCause, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorCause = errorCause;
        this.errorCode = errorCode;
        this.timestamp = ZonedDateTime.now();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Throwable getErrorCause() {
        return errorCause;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

}