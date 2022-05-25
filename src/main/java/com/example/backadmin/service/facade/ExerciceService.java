package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Exercice;

import java.util.List;

public interface ExerciceService {
    Exercice findByReference(String reference);

    List<Exercice> findAll();
}
