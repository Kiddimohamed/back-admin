package com.example.backadmin.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private String userName;
    @ManyToOne
    private ServiceDemandeur serviceDemandeur;
    @OneToMany
    private List<ExpressionBesoin> expressionBesoins;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ServiceDemandeur getServiceDemandeur() {
        return serviceDemandeur;
    }

    public void setServiceDemandeur(ServiceDemandeur serviceDemandeur) {
        this.serviceDemandeur = serviceDemandeur;
    }

    public List<ExpressionBesoin> getExpressionBesoins() {
        return expressionBesoins;
    }

    public void setExpressionBesoins(List<ExpressionBesoin> expressionBesoins) {
        this.expressionBesoins = expressionBesoins;
    }
}
