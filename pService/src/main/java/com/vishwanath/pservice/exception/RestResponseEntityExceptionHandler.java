package com.vishwanath.pservice.exception;

import com.vishwanath.pservice.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {
   @ExceptionHandler(ProductServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceCustomException ex) {
        return new ResponseEntity<>(new ErrorResponse().builder()
                .errorMessage(ex.getErrorCode())
                .errorCode(ex.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

}
