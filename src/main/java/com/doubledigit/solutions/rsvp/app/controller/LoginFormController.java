package com.doubledigit.solutions.rsvp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/farm")
public class LoginFormController {


    @GetMapping("/login/guest")
    @ResponseBody
    public String loginGuest(@RequestParam("user") String userName,
                            @RequestParam("pass") String password) {
        String message = "Welcome to FarmUp, guest " + userName + "!";
        return message;
    }

    @PostMapping("/login/auth")
    @ResponseBody
    public String loginUser(RedirectAttributes flashAtts,
                            @RequestParam String username,
                            @RequestParam String password) {

        flashAtts.addAttribute("username", username);
        flashAtts.addAttribute("password", password);
        return "redirect:/farm/admin/menu";
    }

    @GetMapping("/login/auth")
    public String loginUser(){
        return "th_login";
    }

    @GetMapping("/login/role/{user}")
    @ResponseBody
    public String validateUserRole(@PathVariable("user") String userName){
        String message = "User " + userName + " is an Administrator!";
        return message;
    }

    @PostMapping("/login/role/{user}/{pwd:[A-Za-z0-9@$_]{3,20}}")
    @ResponseBody
    public String generatePassphrase(@PathVariable("user") String userName,
                                     @PathVariable("pwd") String password) {
        return new StringBuilder(String.join("", userName, password)).reverse().toString();
    }

}

