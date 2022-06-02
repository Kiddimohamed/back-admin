package com.example.backadmin.service.impl;

import com.example.backadmin.bean.NaturePrestationType;
import com.example.backadmin.dao.NaturePrestationTypeDao;
import com.example.backadmin.service.facade.NaturePrestationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NaturePrestationTypeServiceImpl implements NaturePrestationTypeService {
    @Override
    public NaturePrestationType findByReference(String reference) {
        return naturePrestationTypeDao.findByReference(reference);
    }

    @Transactional
    @Override
    public int deleteByReference(String reference) {
        return naturePrestationTypeDao.deleteByReference(reference);
    }

    @Override
    public List<NaturePrestationType> findAll() {
        return naturePrestationTypeDao.findAll();
    }


    @Override
    public int save(NaturePrestationType naturePrestationType){
      NaturePrestationType naturePrestationType1=findByReference(naturePrestationType.getReference());
        if (naturePrestationType1!=null){
            return -1;
        }else{
            naturePrestationTypeDao.save(naturePrestationType);
            return 1;
        }
    }

    @Autowired
    NaturePrestationTypeDao naturePrestationTypeDao;
}
