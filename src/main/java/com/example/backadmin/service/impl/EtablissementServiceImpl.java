package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Etablissement;
import com.example.backadmin.dao.EtablissementDao;
import com.example.backadmin.service.facade.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtablissementServiceImpl implements EtablissementService {

    @Override
    public Etablissement findByReference(String reference) {
        return etablissementDao.findByReference(reference);
    }

    @Override
    public Etablissement findByVille(String ville) {
        return etablissementDao.findByVille(ville);
    }

    @Override
    public List<Etablissement> findAll() {
        return etablissementDao.findAll();
    }

    @Override
    public int save(Etablissement etablissement){
        Etablissement etablissement1=findByReference(etablissement.getReference());
        if (etablissement1!=null){
            return -1;
        }else {
            etablissementDao.save(etablissement);
            return 1;
        }
    }

    @Autowired
    EtablissementDao etablissementDao;
}
