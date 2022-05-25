package com.example.backadmin.ws;

import com.example.backadmin.bean.Chapitre;
import com.example.backadmin.service.facade.ChapitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/chapitre")
public class ChapitreWs {
    @GetMapping("/reference/{reference}")
    public Chapitre findByReference(@PathVariable String reference) {
        return chapitreService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return chapitreService.deleteByReference(reference);
    }

    @GetMapping("/chapitre-type/reference/{reference}")
    public List<Chapitre> findByChapitreTypeReference(@PathVariable String reference) {
        return chapitreService.findByChapitreTypeReference(reference);
    }

    @GetMapping("/exercice/reference/{reference}")
    public List<Chapitre> findByExerciceReference(@PathVariable  String reference) {
        return chapitreService.findByExerciceReference(reference);
    }

    @GetMapping("/")
    public List<Chapitre> findAll() {
        return chapitreService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Chapitre chapitre) {
        return chapitreService.save(chapitre);
    }

    @Autowired
    ChapitreService chapitreService;
}
