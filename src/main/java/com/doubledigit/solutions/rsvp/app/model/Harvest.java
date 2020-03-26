package com.doubledigit.solutions.rsvp.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "harvest")
public class Harvest {

    @Id
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="qty")
    private Integer qty;

    @Column(name="price")
    private Float price;

    @Column(name="description")
    private String description;

    @Column(name="status")
    private String status;

    @Column(name="type")
    private String type;

    @Column(name="approved")
    private LocalDate approvedDate;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Location location;

    @JsonIgnore
    @OneToMany(targetEntity = Basket.class,
            mappedBy = "id",  orphanRemoval = false,
            fetch = FetchType.LAZY)
    private Set<Basket> basket;

}
