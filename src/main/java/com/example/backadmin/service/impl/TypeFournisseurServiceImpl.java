package com.example.backadmin.service.impl;

import com.example.backadmin.bean.TypeFournisseur;
import com.example.backadmin.dao.TypeFournisseurDao;
import com.example.backadmin.service.facade.TypeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeFournisseurServiceImpl implements TypeFournisseurService {

    @Override
    public TypeFournisseur findByReference(String reference) {
        return typeFournisseurDao.findByReference(reference);
    }

    @Override
    public TypeFournisseur findByType(String type) {
        return typeFournisseurDao.findByType(type);
    }

    @Override
    public List<TypeFournisseur> findAll() {
        return typeFournisseurDao.findAll();
    }

    @Override
    public int save(TypeFournisseur typeFournisseur) {
        TypeFournisseur typeFournisseur1=findByReference(typeFournisseur.getReference());
        if (typeFournisseur1!=null)return -1;
        else {
            typeFournisseurDao.save(typeFournisseur);
        return 1;
    }}


    @Autowired
    private TypeFournisseurDao typeFournisseurDao;
}
