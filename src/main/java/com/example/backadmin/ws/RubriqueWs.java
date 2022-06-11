package com.example.backadmin.ws;

import com.example.backadmin.bean.Rubrique;
import com.example.backadmin.service.facade.RubriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/rubrique")
public class RubriqueWs {
    @GetMapping("/reference/{reference}")
    public Rubrique findByReference(@PathVariable String reference) {
        return rubriqueService.findByReference(reference);
    }

    @PostMapping("/")
    public int save(@RequestBody Rubrique rubrique) {
        return rubriqueService.save(rubrique);
    }

    @GetMapping("/ligneLibelle/{ligneLibelle}")
    public List<Rubrique> findByLigneLibelle(@PathVariable String ligneLibelle) {
        return rubriqueService.findByLigneLibelle(ligneLibelle);
    }

    @GetMapping("/")
    public List<Rubrique> findAll() {
        return rubriqueService.findAll();
    }

    @Autowired
    private RubriqueService rubriqueService;
}
