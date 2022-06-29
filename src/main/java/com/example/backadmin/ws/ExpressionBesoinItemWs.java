package com.example.backadmin.ws;

import com.example.backadmin.bean.Employe;
import com.example.backadmin.bean.ExpressionBesoinItem;
import com.example.backadmin.service.facade.EmployeService;
import com.example.backadmin.service.facade.ExpressionBesoinItemService;
import com.example.backadmin.service.facade.ExpressionBesoinService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/v1/admin/expression-besoin-item")
public class ExpressionBesoinItemWs {
    @GetMapping("/ref/{ref}")
    public ExpressionBesoinItem findByRef(@PathVariable String ref) {
        return expressionBesoinItemService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return expressionBesoinItemService.deleteByRef(ref);
    }

    @GetMapping("/expression-besoin/reference/{reference}")
    public List<ExpressionBesoinItem> findByExpressionDeBesoinReference(@PathVariable String reference) {
        return expressionBesoinItemService.findByExpressionBesoinReference(reference);
    }

    @GetMapping("/")
    public List<ExpressionBesoinItem> findAll() {
        return expressionBesoinItemService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody ExpressionBesoinItem expressionBesoinItem) {
        return expressionBesoinItemService.save(expressionBesoinItem);
    }

    @GetMapping("/expression-besoin/objet/{objet}")
    public List<ExpressionBesoinItem> findByExpressionDeBesoinObjet(@PathVariable String objet) {
        return expressionBesoinItemService.findByExpressionBesoinObjet(objet);
    }

    @GetMapping("/imprimer/objet/{objet}")
    public String imprimer(@PathVariable String objet) throws FileNotFoundException, JRException {
        return expressionBesoinItemService.imprimer(objet);
    }

    @GetMapping("/expression-besoin/statut/{statut}")
    public List<ExpressionBesoinItem> findByExpressionBesoinStatut(@PathVariable String statut) {
        return expressionBesoinItemService.findByExpressionBesoinStatut(statut);
    }

    @GetMapping("/statut/{statut}")
    public List<ExpressionBesoinItem> findByStatut(@PathVariable String statut) {
        return expressionBesoinItemService.findByStatut(statut);
    }

    @Autowired
    private ExpressionBesoinItemService expressionBesoinItemService;
}
