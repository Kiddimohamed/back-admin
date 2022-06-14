package com.example.backadmin.ws;

import com.example.backadmin.bean.Commande;
import com.example.backadmin.service.facade.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    public List<Commande> findByTableauBesoinItemReference(@PathVariable String reference) {
        return commandeService.findByTableauBesoinItemReference(reference);
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
    @GetMapping("/graph_commande_budjet")
    public List<String> graph_commande_budjet(String e1, String e2, String e3, String e4, String e5, String e6, String e7, String e8, String e9, String e10, String e11, String e12) {
        return commandeService.graph_commande_budjet(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);
    }

    @GetMapping("/getttc_par_anne")
    public BigDecimal ttc_par_annes(){
        return commandeService.ttc_par_annes(LocalDate.now().getYear());
    }

        @Autowired
    CommandeService commandeService;
}


