package com.mbste.ExceptionH;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @gatete Rugamba
 * @15/11/2018
 * for Handlering all exceptions thrown
 */
@ControllerAdvice
public class NotFoundExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NotFoundException notFound){

        ErrorResponse response=new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                                            notFound.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception notFound){

        ErrorResponse response=new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                notFound.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
