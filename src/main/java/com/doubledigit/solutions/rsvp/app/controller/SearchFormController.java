package com.doubledigit.solutions.rsvp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class SearchFormController {

    @Autowired
    private String projectName;

    @GetMapping("/farm/search")
    public String initForm(Model model) {
        model.addAttribute("projName", projectName);
        return "ftl_search_form";
    }

    @PostMapping("/farm/search")
    public String submitForm(Model model, @RequestParam("keyword") String keyword) {
        model.addAttribute("projName", projectName);
        model.addAttribute("keyword", keyword);
        model.addAttribute("harvest", references());

        return "ftl_search_result";
    }

    private List<String> references() {
        return Arrays.asList("Apple", "Tomato", "Mango");

    }
}
