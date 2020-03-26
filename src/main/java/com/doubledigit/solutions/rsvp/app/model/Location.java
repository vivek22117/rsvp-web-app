package com.doubledigit.solutions.rsvp.app.model;


import com.doubledigit.solutions.rsvp.app.model.Harvest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "location")
public class Location {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "owner")
    private String owner;

    @Column(name = "hid")
    private Long hid;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "location")
    private Harvest harvest;

}
