package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Produit;
import com.example.backadmin.dao.ProduitDao;
import com.example.backadmin.service.facade.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Override
    public Produit findByLibelle(String libelle) {
        return produitDao.findByLibelle(libelle);
    }

    @Override
    public Produit findByNumeroInventaire(String numeroInventaire) {
        return produitDao.findByNumeroInventaire(numeroInventaire);
    }

    @Override
    public Produit findByCode(String code) {
        return produitDao.findByCode(code);
    }

    @Override
    public List<Produit> findAll() {
        return produitDao.findAll();
    }

    @Override
    public int save(Produit produit) {
        produit.setCode("produit" + (getMaxId() + 1));
        produitDao.save(produit);
        return 1;

    }

    @Override
    public Long getMaxId() {
        return produitDao.getMaxId();
    }

    @Autowired
    ProduitDao produitDao;

}
