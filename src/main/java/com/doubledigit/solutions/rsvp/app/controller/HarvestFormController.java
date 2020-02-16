package com.doubledigit.solutions.rsvp.app.controller;

import com.doubledigit.solutions.rsvp.app.model.HarvestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/farm/harvest/add")
public class HarvestFormController {

    @Autowired
    private String projectName;

    @Autowired
    private LocalDate localDate;

    @Autowired
    private List<HarvestForm> dbHarvest;

    @GetMapping
    public String initForm(Model model) {
        model.addAttribute("projName", projectName);
        model.addAttribute("harvestForm", new HarvestForm());

        Map<String, String> types = new LinkedHashMap<String, String>();
        types.put("veggie", "Vegetable");
        types.put("fruit", "Fruit");

        Map<String, String> status = new LinkedHashMap<String, String>();
        status.put("ok", "OK");
        status.put("expired", "EXPIRED");

        model.addAttribute("types", types);
        model.addAttribute("status", status);
        model.addAttribute("harvestForm", new HarvestForm());
        return "ftl_harvest_form";
    }

    @PostMapping
    public String submitForm(Model model, @RequestParam Integer id, @RequestParam String name,
                             @RequestParam Integer quantity, @RequestParam String description,
                             @RequestParam Float price, @RequestParam String deliveryDate,
                             @RequestParam String location, @RequestParam String owner, @RequestParam String type,
                             @RequestParam String status) {
        model.addAttribute("projName", projectName);
        model.addAttribute("ldate", localDate);
        model.addAttribute("header", "List of Harvest");

        HarvestForm form = new HarvestForm();
        form.setId(id);
        form.setName(name);
        form.setQuantity(quantity);
        form.setPrice(price);
        form.setDescription(description);
        form.setDeliveryDate(deliveryDate);
        form.setOwner(owner);
        form.setLocation(location);
        form.setStatus(status);
        form.setType(type);

        dbHarvest.add(form);
        model.addAttribute("dbHarvest", dbHarvest);
        return "ftl_harvest_list";
    }
}
