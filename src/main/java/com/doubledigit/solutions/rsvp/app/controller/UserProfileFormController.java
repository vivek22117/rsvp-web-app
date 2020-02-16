package com.doubledigit.solutions.rsvp.app.controller;

import com.doubledigit.solutions.rsvp.app.model.ProfileForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/farm/users/profile")
public class UserProfileFormController {

    @GetMapping
    public String initForm(Model model){
        model.addAttribute("username", "vivekm");
        model.addAttribute("profileForm", new ProfileForm());

        return "th_users_profile";
    }

    @PostMapping
    public String submitForm(Model model){
        model.addAttribute("username", "vivekm");
        return "th_users_profile";
    }

}
