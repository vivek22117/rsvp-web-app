package com.doubledigit.solutions.rsvp.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FarmUpExceptionHandler {


    @ExceptionHandler(value = NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @GetMapping("/farm/error/null")
    public String throwNullException(Exception ex) {
        System.err.println(ex.getClass());
        return "mst_farm_null_exception";
    }

    @ExceptionHandler(value = NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @GetMapping("/farm/error/format")
    public String throwFormatException(Exception ex) {
        System.err.println(ex.getClass());
        return "mst_farm_format_exception";
    }

    @ExceptionHandler(value = EmailFormException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @GetMapping("/email/error")
    public String throwEmailFormException(Exception ex){
        return "mst_email_exception";
    }

    @ExceptionHandler(value = HarvestFormException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @GetMapping("/harvest/error")
    public String throwHarvestFormException(Exception ex){
        return "mst_harvest_exception";
    }

    @ExceptionHandler(value = AuthenticationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @GetMapping("/login/auth/error")
    public String throwSignupFormException(Exception ex) {
        return "mst_authentication_error";
    }
}
