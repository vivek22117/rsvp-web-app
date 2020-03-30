package com.doubledigit.solutions.rsvp.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "basket")
public class Basket {

    @Id
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "hid")
    private Long hid;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "approved_by")
    private String approvedBy;

    @Column(name = "approved_date")
    private LocalDate approvedDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Login login;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hid", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Harvest harvest;


}
