package com.doubledigit.solutions.rsvp.app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "permission")
public class Permission {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(targetEntity = PermissionSets.class, mappedBy = "id",
            orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<PermissionSets> permissionSets;
}
