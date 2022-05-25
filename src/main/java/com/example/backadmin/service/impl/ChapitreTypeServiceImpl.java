package com.example.backadmin.service.impl;

import com.example.backadmin.bean.ChapitreType;
import com.example.backadmin.dao.ChapitreTypeDao;
import com.example.backadmin.service.facade.ChapitreTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChapitreTypeServiceImpl implements ChapitreTypeService {


    @Override
    public ChapitreType findByReference(String reference) {
        return chapitreTypeDao.findByReference(reference);
    }


    @Transactional
    @Override
    public int deleteByReference(String reference) {
        return chapitreTypeDao.deleteByReference(reference);
    }

    @Override
    public List<ChapitreType> findAll() {
        return chapitreTypeDao.findAll();
    }

    @Override
    public int save(ChapitreType chapitreType) {
        ChapitreType chapitreType1 = findByReference(chapitreType.getReference());
        if (chapitreType1 != null) {
            return -1;
        } else {
            chapitreTypeDao.save(chapitreType);
            return 1;
        }
    }

    @Autowired
    ChapitreTypeDao chapitreTypeDao;
}
