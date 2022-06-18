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
    //statistique
    @GetMapping("/nbrExpressionBesoinEnattente")
    int expressionBesoinEncours(){
        return expressionBesoinService.expressionBesoinEncours();
    }

//microservice
    @GetMapping("microservice/getNumberOfExpressionBesoinEnAttente")
public int getNumberOfExpressionBesoinEnAttente() {
        return expressionBesoinService.getNumberOfExpressionBesoinEnAttente();
}
    @GetMapping("/monthv2")
    public List<String> graph_monsuel(String e1, String e2, String e3, String e4, String e5, String e6, String e7, String e8, String e9, String e10, String e11, String e12) {
        return expressionBesoinService.graph_monsuel(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);
    }

    @Autowired
    ExpressionBesoinService expressionBesoinService;
}
