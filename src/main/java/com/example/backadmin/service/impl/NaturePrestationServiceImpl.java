package com.example.backadmin.service.impl;

import com.example.backadmin.bean.NaturePrestation;
import com.example.backadmin.bean.NaturePrestationType;
import com.example.backadmin.dao.NaturePrestationDao;
import com.example.backadmin.service.facade.NaturePrestationService;
import com.example.backadmin.service.facade.NaturePrestationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NaturePrestationServiceImpl implements NaturePrestationService {
    @Override
    public NaturePrestation findByReference(String reference) {
        return naturePrestationDao.findByReference(reference);
    }

    @Transactional
    @Override
    public int deleteByReference(String reference) {
        return naturePrestationDao.deleteByReference(reference);
    }

    @Override
    public List<NaturePrestation> findByNaturePrestationTypeReference(String reference) {
        return naturePrestationDao.findByNaturePrestationTypeReference(reference);
    }

    @Override
    public List<NaturePrestation> findAll() {
        return naturePrestationDao.findAll();
    }

    @Override
    public int save(NaturePrestation naturePrestation){
        NaturePrestation naturePrestation1=findByReference(naturePrestation.getReference());
       prepare(naturePrestation);

        if (naturePrestation1!=null){
            return -1;
        }else if(naturePrestation.getNaturePrestationType()==null){
            return -2;}
        else{
            naturePrestationDao.save(naturePrestation);
            return 1;
        }
    }

    private void prepare(NaturePrestation naturePrestation) {
        NaturePrestationType naturePrestationType=naturePrestationTypeService.findByReference(naturePrestation.getNaturePrestationType().getReference());
        naturePrestation.setNaturePrestationType( naturePrestationType);
    }

    @Autowired
    NaturePrestationDao naturePrestationDao;
    @Autowired
    NaturePrestationTypeService naturePrestationTypeService;
}
