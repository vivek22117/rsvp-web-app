package com.doubledigit.solutions.rsvp.app.model;

import lombok.Data;

@Data
public class HarvestForm {

    private Integer id;
    private String name;
    private Integer quantity;
    private Float price;
    private String location;
    private String description;
    private String status;
    private String deliveryDate;
    private String type;
    private String owner;

}
