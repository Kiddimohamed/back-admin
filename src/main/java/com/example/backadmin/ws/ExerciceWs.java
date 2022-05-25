package com.example.backadmin.ws;

import com.example.backadmin.bean.Exercice;
import com.example.backadmin.service.facade.ExerciceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/v1/admin/exercice")
public class ExerciceWs {

    @GetMapping("/reference/{reference}")
    public Exercice findByReference(@PathVariable  String reference) {
        return exerciceService.findByReference(reference);
    }

    @GetMapping("/")
    public List<Exercice> findAll() {
        return exerciceService.findAll();
    }

    @Autowired
    ExerciceService exerciceService;
}
