package com.example.backadmin.bean;



import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String username;
    private String serviceDemandeur;

    @OneToMany
    private List<ExpressionBesoin> expressionBesoins;
//
//    public ServiceDemandeur getServiceDemandeur() {return serviceDemandeur;}
//
//    public void setServiceDemandeur(ServiceDemandeur serviceDemandeur) {this.serviceDemandeur = serviceDemandeur;}


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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getServiceDemandeur() {
        return serviceDemandeur;
    }

    public void setServiceDemandeur(String serviceDemandeur) {
        this.serviceDemandeur = serviceDemandeur;
    }

    public List<ExpressionBesoin> getExpressionBesoins() {
        return expressionBesoins;
    }

    public void setExpressionBesoins(List<ExpressionBesoin> expressionBesoins) {
        this.expressionBesoins = expressionBesoins;
    }
}
