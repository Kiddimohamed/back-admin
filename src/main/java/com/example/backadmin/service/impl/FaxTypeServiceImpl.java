package com.example.backadmin.service.impl;

import com.example.backadmin.bean.FaxType;
import com.example.backadmin.dao.FaxTypeDao;
import com.example.backadmin.service.facade.FaxTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaxTypeServiceImpl implements FaxTypeService {

    @Override
    public FaxType findByCode(String code) {
        return faxTypeDao.findByCode(code);
    }
    @Override
    public FaxType findByLibelle(String libelle) {
        return faxTypeDao.findByLibelle(libelle);
    }
    @Override
    public List<FaxType> findAll() {
        return faxTypeDao.findAll();
    }

    @Override
    public int save(FaxType faxType){
        FaxType faxType1=findByCode(faxType.getCode());
        if (faxType1!=null){
            return -1;
        }else {
            faxTypeDao.save(faxType);
            return 1;
        }
    }

    @Autowired
    FaxTypeDao faxTypeDao;
}
