package com.example.backadmin.ws;

import com.example.backadmin.bean.Produit;
import com.example.backadmin.service.facade.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/produit")
public class ProduitWs {

    @GetMapping("/libelle/{libelle}")
    public Produit findByLibelle(@PathVariable String libelle) {
        return produitService.findByLibelle(libelle);
    }

    @GetMapping("/numero-inventaire/{numeroInventaire}")
    public Produit findByNumeroInventaire(@PathVariable String numeroInventaire) {
        return produitService.findByNumeroInventaire(numeroInventaire);
    }

    @GetMapping("/code/{code}")
    public Produit findByCode(@PathVariable String code) {
        return produitService.findByCode(code);
    }

    @GetMapping("/")
    public List<Produit> findAll() {
        return produitService.findAll();
    }

    @PostMapping("/")

    public int save(@RequestBody Produit produit) {
        return produitService.save(produit);
    }

    @Autowired
    ProduitService produitService;
}
