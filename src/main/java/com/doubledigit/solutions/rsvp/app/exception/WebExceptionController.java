package com.doubledigit.solutions.rsvp.app.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class WebExceptionController implements ErrorController {


    @GetMapping("/error")
    @ExceptionHandler(value = NullPointerException.class)
    public String NullExceptionHandler(HttpServletResponse response) {
        if (response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return "mst_farm_generic_500";
        } else if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            return "mst_farm_generic_404";
        }
        return "mst_farm_generic_404";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
