package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Employe;
import com.example.backadmin.bean.ExpressionBesoin;
import com.example.backadmin.bean.ServiceDemandeur;
import com.example.backadmin.dao.ExpressionBesoinDao;
import com.example.backadmin.service.facade.EmployeService;
import com.example.backadmin.service.facade.ExpressionBesoinItemService;
import com.example.backadmin.service.facade.ExpressionBesoinService;
import com.example.backadmin.service.facade.ServiceDemandeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressionBesoinServiceImpl implements ExpressionBesoinService {

    @Override
    public ExpressionBesoin findByObjet(String objet) {
        return expressionBesoinDao.findByObjet(objet);
    }

    @Override
    public ExpressionBesoin findByReference(String reference) {
        return expressionBesoinDao.findByReference(reference);
    }

    @Override
    public List<ExpressionBesoin> findByEmployeReference(String reference) {
        return expressionBesoinDao.findByEmployeReference(reference);
    }

    @Override
    public List<ExpressionBesoin> findByServiceDemandeurReference(String reference) {
        return expressionBesoinDao.findByServiceDemandeurReference(reference);
    }

    @Override
    public List<ExpressionBesoin> findAll() {
        return expressionBesoinDao.findAll();
    }

    // TODO all Delete
    // TODO Validate a Simo
    @Override
    public int save(ExpressionBesoin expressionBesoin) {
        ExpressionBesoin expressionBesoin1 = findByReference(expressionBesoin.getReference());
        prepare(expressionBesoin);
        if (expressionBesoin1 != null) {
            return -1;
        } else if (expressionBesoin.getEmploye() == null) {
            return -2;
        } else {
            expressionBesoinDao.save(expressionBesoin);
            expressionBesoin.getExpressionBesoinItemList().forEach(expressionBesoinItem -> {
                expressionBesoinItem.setExpressionBesoin(expressionBesoin);
                expressionBesoinItemService.save(expressionBesoinItem);
            });
            return 1;
        }
    }

    private void prepare(ExpressionBesoin expressionBesoin) {
        Employe employe = employeService.findByReference(expressionBesoin.getEmploye().getReference());
        expressionBesoin.setEmploye(employe);
        ServiceDemandeur serviceDemandeur = serviceDemandeurService.findByReference(expressionBesoin.getServiceDemandeur().getReference());
        expressionBesoin.setServiceDemandeur(serviceDemandeur);

    }

    @Autowired
    ExpressionBesoinDao expressionBesoinDao;
    @Autowired
    EmployeService employeService;
    @Autowired
    ServiceDemandeurService serviceDemandeurService;
    @Autowired
    ExpressionBesoinItemService expressionBesoinItemService;
}
