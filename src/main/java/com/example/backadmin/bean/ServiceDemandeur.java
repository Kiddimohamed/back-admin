package com.example.backadmin.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ServiceDemandeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;

    @OneToMany
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    private List<User> users;

//    @ManyToOne
//    Etablissement etablissement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Etablissement getEtablissement() {
//        return etablissement;
//    }
//
//    public void setEtablissement(Etablissement etablissement) {
//        this.etablissement = etablissement;
//    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
