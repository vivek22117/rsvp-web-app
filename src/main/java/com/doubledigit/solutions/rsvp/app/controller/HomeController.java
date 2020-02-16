package com.doubledigit.solutions.rsvp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/farm/home")
public class HomeController {

    @Autowired
    private String projectName;

    @Autowired
    private String webmaster;

    @Autowired
    private LocalDate localDate;

    @GetMapping(value = "/footer")
    @ResponseBody
    public String showFooter() {
        return String.join(" ", "Contact Administrator @ ", webmaster);
    }

    @GetMapping(value = "/header")
    @ResponseBody
    public String showHeader() {
        return projectName;
    }

    @PostMapping(value = "/accessDate")
    @ResponseBody
    public String siteAccess() {
        return localDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
    }

}
