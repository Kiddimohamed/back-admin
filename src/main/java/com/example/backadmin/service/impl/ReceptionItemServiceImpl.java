package com.example.backadmin.service.impl;


import com.example.backadmin.bean.ReceptionItem;
import com.example.backadmin.dao.ReceptionItemDao;
import com.example.backadmin.service.facade.ReceptionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionItemServiceImpl implements ReceptionItemService {
    @Override
    public ReceptionItem findByReferenceReceptionItem(String reference) {
        return receptionItemDao.findByReferenceReceptionItem(reference);
    }

    @Override
    public List<ReceptionItem> findByReceptionReferenceReception(String referenceReception) {
        return receptionItemDao.findByReceptionReferenceReception(referenceReception);
    }

    @Override
    public List<ReceptionItem> findAll() {
        return receptionItemDao.findAll();
    }

    @Autowired
ReceptionItemDao receptionItemDao;
}
