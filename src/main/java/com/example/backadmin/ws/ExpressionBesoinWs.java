package com.example.backadmin.ws;

import com.example.backadmin.bean.ExpressionBesoin;
import com.example.backadmin.service.facade.ExpressionBesoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/expression-besoin")
public class ExpressionBesoinWs {
    @GetMapping("/objet/{objet}")
    public ExpressionBesoin findByObjet(@PathVariable String objet) {
        return expressionBesoinService.findByObjet(objet);
    }

    @GetMapping("/reference/{reference}")
    public ExpressionBesoin findByReference(@PathVariable String reference) {
        return expressionBesoinService.findByReference(reference);
    }

    @PostMapping("/isNull/")
    public void saveNull(@RequestBody  ExpressionBesoin expressionBesoin) {
        expressionBesoinService.saveNull(expressionBesoin);
    }


//    @GetMapping("/service-demandeur/reference/{reference}")
//    public List<ExpressionBesoin> findByServiceDemandeurReference(@PathVariable String reference) {
//        return expressionBesoinService.findByServiceDemandeurReference(reference);
//    }

    @GetMapping("/statut/{statut}")
    public List<ExpressionBesoin> findByStatut(@PathVariable String statut) {
        return expressionBesoinService.findByStatut(statut);
    }

    @GetMapping("/")
    public List<ExpressionBesoin> findAll() {
        return expressionBesoinService.findAll();
    }


    @PostMapping("/")
    public int save(@RequestBody ExpressionBesoin expressionBesoin) {
        return expressionBesoinService.save(expressionBesoin);
    }


    @Autowired
    ExpressionBesoinService expressionBesoinService;
}
