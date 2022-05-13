package com.example.backadmin.service.impl;

import com.example.backadmin.bean.*;
import com.example.backadmin.dao.FaxDao;
import com.example.backadmin.service.facade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaxServiceImpl implements FaxService {

    @Override
    public Fax findByReferenceFax(String referenceFax) {
        return faxDao.findByReferenceFax(referenceFax);
    }

    @Override
    public Fax findByExpressionBesoinReference(String reference) {
        return faxDao.findByExpressionBesoinReference(reference);
    }

    @Override
    public List<Fax> findByFournisseurReferenceFournisseur(String reference) {
        return faxDao.findByFournisseurReferenceFournisseur(reference);
    }

    @Override
    public List<Fax> findByFaxTypeCode(String code) {
        return faxDao.findByFaxTypeCode(code);
    }

    @Override
    public List<Fax> findAll() {
        return faxDao.findAll();
    }

    @Override
    public int save(Fax fax) {
        Fax fax1=findByReferenceFax(fax.getReferenceFax());
        prepare(fax);
        if(fax1!=null) {
            return -1;
        }else if (fax.getFaxType()==null || fax.getEmetteur()==null || fax.getExpressionBesoin()==null || fax.getFournisseur()==null){
            return -2;
        }else{
            faxDao.save(fax);
            return 1;
        }

    }

    private void prepare(Fax fax) {
        FaxType faxType = faxTypeService.findByCode(fax.getFaxType().getCode());
        fax.setFaxType(faxType);
        Employe employe = employeService.findByReferenceEmploye(fax.getEmetteur().getReferenceEmploye());
        fax.setEmetteur(employe);
        ExpressionBesoin expressionBesoin = expressionBesoinService.findByReference(fax.getExpressionBesoin().getReference());
        fax.setExpressionBesoin(expressionBesoin);
        Fournisseur fournisseur = fournisseurService.findByReferenceFournisseur(fax.getFournisseur().getReferenceFournisseur());
        fax.setFournisseur(fournisseur);
    }


    @Autowired
    FaxDao faxDao;

    @Autowired
    FaxTypeService faxTypeService;
    @Autowired
    EmployeService employeService;
    @Autowired
    ExpressionBesoinService expressionBesoinService;
    @Autowired
    FournisseurService fournisseurService;

}
