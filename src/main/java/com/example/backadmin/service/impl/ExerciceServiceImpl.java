package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Exercice;
import com.example.backadmin.dao.ExerciceDao;
import com.example.backadmin.service.facade.ExerciceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciceServiceImpl implements ExerciceService {
    @Override
    public Exercice findByReference(String reference) {
        return exerciceDao.findByReference(reference);
    }

    @Override
    public List<Exercice> findAll() {
        return exerciceDao.findAll();
    }

    @Autowired
    ExerciceDao exerciceDao;
}
