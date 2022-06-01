package com.example.backadmin.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class TypeFournisseur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    public Long id;
    public String reference;
    public String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
