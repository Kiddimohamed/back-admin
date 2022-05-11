package com.example.backadmin.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class FaxType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String libelle;

    @OneToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<Fax> faxList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Fax> getFaxList() {
        return faxList;
    }

    public void setFaxList(List<Fax> faxList) {
        this.faxList = faxList;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
