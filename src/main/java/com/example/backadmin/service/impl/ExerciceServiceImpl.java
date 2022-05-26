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


    @Override
    public int save(Exercice exercice){
        Exercice exercice1=findByReference(exercice.getReference());
        if (exercice1!=null){
            return -1;
        }else {
            exerciceDao.save(exercice);
            return 1;
        }
    }
    @Autowired
    ExerciceDao exerciceDao;
}
