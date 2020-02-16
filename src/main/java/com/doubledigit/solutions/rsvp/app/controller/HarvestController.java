package com.doubledigit.solutions.rsvp.app.controller;

import com.doubledigit.solutions.rsvp.app.model.HarvestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/farm/harvest")
public class HarvestController {

    private List<HarvestForm> dbHarvest = new ArrayList<HarvestForm>();

    @Autowired
    private String projectName;

    @GetMapping("/list")
    public String listHarvest(Model model){
        model.addAttribute("projName", projectName);
        model.addAttribute("headers", "List Of Harvest");

        HarvestForm form = new HarvestForm();

        form.setId(1);
        form.setName("Tomato");
        form.setPrice(303.22F);
        form.setQuantity(111);
        form.setLocation("Pune India");
        form.setType("Vegetable");
        form.setDeliveryDate("March 15, 1987");
        form.setDescription("Juicy vegetable....");
        form.setStatus("true");
        form.setOwner("Vivek");

        dbHarvest.add(form);
        model.addAttribute("harvest", dbHarvest);
        return "ftl_harvest_list";
    }


}
