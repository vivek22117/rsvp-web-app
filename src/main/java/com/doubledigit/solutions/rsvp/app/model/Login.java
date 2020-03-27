package com.doubledigit.solutions.rsvp.app.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "login")
public class Login {

    @Id
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "passphrase")
    private String passphrase;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Profile profile;


}
