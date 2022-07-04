package com.example.backadmin.ws;

import com.example.backadmin.bean.Fournisseur;
import com.example.backadmin.service.facade.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/fournisseur")
public class FournisseurWs {
    @GetMapping("/statut/{statut}")
    public List<Fournisseur> findByStatut(@PathVariable String statut) {
        return fournisseurService.findByStatut(statut);
    }

    @PutMapping ("/updateStatut")
    public int updateStatut(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.updateStatut(fournisseur);
    }

    @GetMapping("/reference/{reference}")
    public Fournisseur findByReferenceFournisseur(@PathVariable String reference) {
        return fournisseurService.findByReferenceFournisseur(reference);
    }

    @GetMapping("/ville/{ville}")

    public Fournisseur findByVilleFournisseur(@PathVariable String ville) {
        return fournisseurService.findByVilleFournisseur(ville);
    }

    @GetMapping("/")

    public List<Fournisseur> findAll() {
        return fournisseurService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.save(fournisseur);
    }

    @PutMapping("/rib")
    public int updateRib(@RequestBody Fournisseur fournisseur){
        return fournisseurService.updateRib(fournisseur);
    }

    @Autowired
    FournisseurService fournisseurService;
}
