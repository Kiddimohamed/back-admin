package com.example.backadmin.ws;

import com.example.backadmin.bean.Exercice;
import com.example.backadmin.service.facade.ExerciceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/")
    public int save(@RequestBody Exercice exercice) {
        return exerciceService.save(exercice);
    }

    @Autowired
    ExerciceService exerciceService;
}
