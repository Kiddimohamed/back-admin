package com.example.backadmin.ws;

import com.example.backadmin.bean.Employe;
import com.example.backadmin.bean.ExpressionBesoinItem;
import com.example.backadmin.service.facade.EmployeService;
import com.example.backadmin.service.facade.ExpressionBesoinItemService;
import com.example.backadmin.service.facade.ExpressionBesoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/expression-besoin-item")
public class ExpressionBesoinItemWs {
    @GetMapping("/expression-besoin/statut/{statut}")
    public List<ExpressionBesoinItem> findByExpressionBesoinStatut(@PathVariable String statut) {
        return expressionBesoinItemService.findByExpressionBesoinStatut(statut);
    }

    @GetMapping("/refExpr/{refExpr}")
    public List<ExpressionBesoinItem> findByRefExpr(@PathVariable String refExpr) {
        return expressionBesoinItemService.findByRefExpr(refExpr);
    }

    @GetMapping("/expression-besoin/reference/{reference}")
    public List<ExpressionBesoinItem> findByExpressionBesoinReference(@PathVariable String reference) {
        return expressionBesoinItemService.findByExpressionBesoinReference(reference);
    }

    @GetMapping("/")
    public List<ExpressionBesoinItem> findAll() {
        return expressionBesoinItemService.findAll();
    }

    @GetMapping("/code/{code}")

    public ExpressionBesoinItem findByCode(@PathVariable String code) {
        return expressionBesoinItemService.findByCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody ExpressionBesoinItem expressionBesoinItem) {
        return expressionBesoinItemService.save(expressionBesoinItem);
    }

    @GetMapping("/statut/{statut}")
    public List<ExpressionBesoinItem> findByStatut(@PathVariable String statut) {
        return expressionBesoinItemService.findByStatut(statut);
    }

    @PutMapping("/")
    public int update(@RequestBody ExpressionBesoinItem expressionBesoinItem) {
        return expressionBesoinItemService.update(expressionBesoinItem);
    }

    @GetMapping("/tableau-besoin/{reference}")
    public List<ExpressionBesoinItem> findByTableauBesoinReference(@PathVariable String reference) {
        return expressionBesoinItemService.findByTableauBesoinReference(reference);
    }

    @Autowired
    ExpressionBesoinItemService expressionBesoinItemService;
}
