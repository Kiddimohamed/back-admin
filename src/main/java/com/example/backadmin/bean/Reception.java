package com.example.backadmin.bean;

import net.sf.jasperreports.web.commands.Command;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Reception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String referenceReception;

    private Date dateReception;

    @ManyToOne
    private Fournisseur fournisseur;

    @ManyToOne
    private Commande commande;
    @OneToMany
    private List<ReceptionItem> receptionItemList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceReception() {
        return referenceReception;
    }

    public void setReferenceReception(String referenceReception) {
        this.referenceReception = referenceReception;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<ReceptionItem> getReceptionItemList() {
        return receptionItemList;
    }

    public void setReceptionItemList(List<ReceptionItem> receptionItemList) {
        this.receptionItemList = receptionItemList;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
