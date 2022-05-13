package com.example.backadmin.bean;

import javax.persistence.*;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String referenceEmploye;
    private String nomEmploye;
    private String adresseEmploye;
    private String telephoneEmploye;
    private String  faxEmploye;
    private String fonctionEmploye;

    @ManyToOne
    private Etablissement etablissement;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceEmploye() {
        return referenceEmploye;
    }

    public void setReferenceEmploye(String referenceEmploye) {
        this.referenceEmploye = referenceEmploye;
    }

    public String getFonctionEmploye() {
        return fonctionEmploye;
    }

    public void setFonctionEmploye(String fonctionEmploye) {
        this.fonctionEmploye = fonctionEmploye;
    }

    public String getNomEmployeEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public String getAdresseEmploye() {
        return adresseEmploye;
    }

    public void setAdresseEmploye(String adresseEmploye) {
        this.adresseEmploye = adresseEmploye;
    }

    public String getTelephoneEmploye() {
        return telephoneEmploye;
    }

    public void setTelephoneEmploye(String telephoneEmploye) {
        this.telephoneEmploye = telephoneEmploye;
    }

    public String getFaxEmploye() {
        return faxEmploye;
    }

    public void setFaxEmploye(String faxEmploye) {
        this.faxEmploye = faxEmploye;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }
}
