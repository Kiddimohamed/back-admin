package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Reception;
import com.example.backadmin.dao.ReceptionDao;
import com.example.backadmin.service.facade.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionServiceImpl  implements ReceptionService {


    @Override
    public Reception findByReferenceReception(String reference) {
        return receptionDao.findByReferenceReception(reference);
    }

    @Override
    public List<Reception> findAll() {
        return receptionDao.findAll();
    }

    @Autowired
    ReceptionDao receptionDao;
}
