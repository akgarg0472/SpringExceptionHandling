package com.akgarg.springexceptionhandling.exception;

import com.akgarg.springexceptionhandling.exception.exceptions.RequestException;
import com.akgarg.springexceptionhandling.exception.exceptions.DatabaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ApiException> handleRequestException(RequestException exception) {
        exception.printStackTrace();
        String errorMessage = exception.getMessage();
        Throwable exceptionCause = exception.getCause();
        HttpStatus errorStatus = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(errorMessage, exceptionCause, errorStatus.value());

        return new ResponseEntity<>(apiException, errorStatus);
    }


    @ExceptionHandler(value = DatabaseException.class)
    public ResponseEntity<ApiException> handleServerException(DatabaseException exception) {
        exception.printStackTrace();
        String errorMessage = exception.getMessage();
        HttpStatus errorStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiException apiException = new ApiException(errorMessage, null, errorStatus.value());

        return new ResponseEntity<>(apiException, errorStatus);
    }

}