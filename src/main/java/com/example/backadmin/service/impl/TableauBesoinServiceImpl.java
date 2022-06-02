package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Fournisseur;
import com.example.backadmin.bean.TableauBesoin;
import com.example.backadmin.dao.TableauBesoinDao;
import com.example.backadmin.service.facade.ExpressionBesoinService;
import com.example.backadmin.service.facade.FournisseurService;
import com.example.backadmin.service.facade.TableauBesoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableauBesoinServiceImpl implements TableauBesoinService {
    @Override
    public void save(TableauBesoin tableauBesoin){
        Fournisseur fournisseur=fournisseurService.findByReferenceFournisseur(tableauBesoin.getFournisseur().getReferenceFournisseur());
        tableauBesoin.setFournisseur(fournisseur);


        tableauBesoinDao.save(tableauBesoin);
    }

    @Autowired
    private TableauBesoinDao tableauBesoinDao;
    @Autowired
    private FournisseurService fournisseurService;
    @Autowired
    private ExpressionBesoinService expressionBesoinService;
}
