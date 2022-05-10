package com.example.backadmin.ws;

import com.example.backadmin.bean.Fournisseur;
import com.example.backadmin.service.facade.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/fournisseur")
public class FournisseurWs {

    @GetMapping("/reference/{reference}")
    public Fournisseur findByReference(@PathVariable String reference) {
        return fournisseurService.findByReference(reference);
    }

    @GetMapping("/ville/{ville}")

    public Fournisseur findByVille(@PathVariable String ville) {
        return fournisseurService.findByVille(ville);
    }

    @GetMapping("/")

    public List<Fournisseur> findAll() {
        return fournisseurService.findAll();
    }

    @PostMapping("/")

    public int save(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.save(fournisseur);
    }

    @Autowired
    FournisseurService fournisseurService;
}
