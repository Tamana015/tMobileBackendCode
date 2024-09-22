package com.deutsche.telco.exceptions;

import com.deutsche.telco.dto.ResponseDto;
import com.deutsche.telco.exceptions.ErrorResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.deutsche.telco.exceptions.TokenNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    protected ResponseEntity<?> handleCriticalException(HttpServletRequest request, HttpServletResponse response, Object handler, BaseException ex) {
        log.error("Exception in request " + new Gson().toJson(request.getRequestURI()) +" " + new Gson().toJson(ex));
        return new ResponseEntity<>(
                new ResponseDto<>(
                        "FAILED_MESSAGE",
                        ex.getErrorCode(),
                        ex.getMessage(),
                        null
                ),
                HttpStatus.OK
        );
    }
}
