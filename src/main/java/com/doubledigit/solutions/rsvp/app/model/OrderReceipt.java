package com.doubledigit.solutions.rsvp.app.model;

import lombok.Data;

@Data
public class OrderReceipt {

    public OrderReceipt(Long bid, Integer quantity, Long hid, String harvestName, Float price) {
        super();
        this.bid = bid;
        this.quantity = quantity;
        this.hid = hid;
        this.harvestName = harvestName;
        this.price = price;
    }

    private Long bid;
    private Integer quantity;
    private Long hid;
    private String harvestName;
    private Float price;
}
