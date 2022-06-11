package com.example.backadmin.ws;

import com.example.backadmin.bean.Commande;
import com.example.backadmin.service.facade.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/commande")
public class CommandeWs {

    @GetMapping("/code/{code}")
    public Commande findByCode(@PathVariable String code) {
        return commandeService.findByCode(code);
    }

    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @GetMapping("/expression-besoin/reference/{reference}")
    public List<Commande> findByExpressionBesoinReference(@PathVariable String reference) {
        return commandeService.findByExpressionBesoinReference(reference);
    }
//
//    @GetMapping("/service-demandeur/reference/{reference}")
//    public List<Commande> findByServiceDemandeurReference(@PathVariable String reference) {
//        return commandeService.findByServiceDemandeurReference(reference);
//    }

    @PostMapping("/")
    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }



    //statistique
    @GetMapping("/getnbrOfCommande")
    public int getnbrOfCommande(){
        return commandeService.getnbrOfCommande();
    }
    @Autowired
    CommandeService commandeService;
}


