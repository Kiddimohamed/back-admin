package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Employe;
import com.example.backadmin.bean.Etablissement;
import com.example.backadmin.dao.EmployeDao;
import com.example.backadmin.service.facade.EmployeService;
import com.example.backadmin.service.facade.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService {
    @Override
    public Employe findByReference(String reference) {
        return employeDao.findByReference(reference);
    }

    @Override
    public Employe findByNom(String nom) {
        return employeDao.findByNom(nom);
    }

    @Override
    public List<Employe> findByEtablissementReference(String reference) {
        return employeDao.findByEtablissementReference(reference);
    }

    @Override
    public List<Employe> findAll() {
        return employeDao.findAll();
    }


    // TODO ValidateSave
    @Override
    public int save(Employe employe) {
        Employe employe1 = findByReference(employe.getReference());
        prepare(employe);
        if (employe1 != null) {
            return -1;
        } else if (employe.getEtablissement() == null) {
            return -2;
        } else {
            employeDao.save(employe);
            return 1;
        }
    }

    private void prepare(Employe employe) {
        Etablissement etablissement = etablissementService.findByReference(employe.getEtablissement().getReference());
        employe.setEtablissement(etablissement);

    }

    @Autowired
    EmployeDao employeDao;

    @Autowired
    EtablissementService etablissementService;
}
