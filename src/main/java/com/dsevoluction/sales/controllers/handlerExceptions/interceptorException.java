package com.dsevoluction.sales.controllers.handlerExceptions;


import com.dsevoluction.sales.services.exceptions.RegraNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class interceptorException {

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<StandardError> firstException (RegraNegocioException e, HttpServletRequest request){

        String error = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(new Date(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationException(MethodArgumentNotValidException e, HttpServletRequest request){
        String error = "existem campos que não foram preenchidos";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(new Date(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

}
