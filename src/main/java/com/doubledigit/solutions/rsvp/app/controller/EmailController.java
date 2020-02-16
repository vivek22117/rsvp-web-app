package com.doubledigit.solutions.rsvp.app.controller;

import com.doubledigit.solutions.rsvp.app.exception.EmailFormException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/farm/email")
public class EmailController {

    @GetMapping
    public String initForm() {
        return "tpl_email_form";
    }

    @PostMapping
    @ResponseBody
    public String submitForm(@RequestBody String email) throws EmailFormException {
        if (email.length() < 50) {
            throw new EmailFormException();
        }
        return email;
    }

    @ExceptionHandler(value = EmailFormException.class)
    @GetMapping("/error")
    public String submitForm(Exception ex) {
        return "mst_email_exception";
    }
}
