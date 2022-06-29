package com.example.backadmin.ws;

import com.example.backadmin.bean.ExpressionBesoin;
import com.example.backadmin.service.facade.ExpressionBesoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/admin/expression-besoin")
public class ExpressionBesoinWs {

        @GetMapping("/reference/{reference}")
        public ExpressionBesoin findByReference(@PathVariable String reference) {
            return expressionBesoinService.findByReference(reference);
        }

        @GetMapping("/historique/{statut}/{username}")
        public List<ExpressionBesoin> findByStatutAndUserUsername(@PathVariable String statut, @PathVariable String username) {
            return expressionBesoinService.findByStatutAndUserUsername(statut, username);
        }

        @GetMapping("/objet/{objet}")
        public ExpressionBesoin findByObjet(@PathVariable String objet) {
            return expressionBesoinService.findByObjet(objet);
        }

        @GetMapping("/date/{date}")
        public ExpressionBesoin findByDateExb(LocalDateTime date) {
            return expressionBesoinService.findByDateExb(date);
        }


        @DeleteMapping("/reference/{reference}")
        public int deleteByReference(@PathVariable String reference) {
            return expressionBesoinService.deleteByReference(reference);
        }

        @GetMapping("/")
        public List<ExpressionBesoin> findAll() {
            return expressionBesoinService.findAll();
        }

        @PostMapping("/")
        public int save(@RequestBody ExpressionBesoin expressionBesoin) {
            return expressionBesoinService.save(expressionBesoin);
        }

        @PutMapping("/accepter")
        public void updateExpressionBesoin(@RequestBody ExpressionBesoin expressionBesoin) {
            expressionBesoinService.updateExpressionBesoin(expressionBesoin);
        }

        @PutMapping("/refuser")
        public void refuser(@RequestBody ExpressionBesoin expressionBesoin) {
            expressionBesoinService.refuser(expressionBesoin);
        }

        //    @GetMapping("/generate-report/report/{reportFormat}/ref/{ref}")
//    public String generateReport(@PathVariable String reportFormat,@PathVariable String ref) throws FileNotFoundException, JRException {
//        return expressionDeBesoinService.generateReport(reportFormat, ref);
//    }
//
//    @GetMapping("/report/type/{reportFormat}/ref/{ref}")
//    public String report(@PathVariable String reportFormat,@PathVariable String ref) throws FileNotFoundException, JRException {
//        return expressionDeBesoinService.report(reportFormat, ref);
//    }
//
//    @GetMapping("/version/type/{type}/ref/{ref}")
//    public String version(@PathVariable String type,@PathVariable String ref) throws FileNotFoundException, JRException {
//        return expressionDeBesoinService.version(type, ref);
//    }
        @GetMapping("/expressionBesoin")
        public String getRefExpressionBesoin(@RequestBody ExpressionBesoin expressionBesoin) {
            return expressionBesoinService.getRefExpressionBesoin(expressionBesoin);
        }

        @GetMapping("/statut/{statut}")
        public List<ExpressionBesoin> findByStatut(@PathVariable String statut) {
            return expressionBesoinService.findByStatut(statut);
        }

        @GetMapping("/nature-demande/nom/{nom}")
        public List<ExpressionBesoin> findByNatureDemandeNom(@PathVariable String nom) {
            return expressionBesoinService.findByNatureDemandeNom(nom);
        }

        @Autowired
        private ExpressionBesoinService expressionBesoinService;

        //statistique
        @GetMapping("/NumberOfExpressionBesoinEnAttente")
        public int getNumberOfExpressionBesoinEnAttente() {
            return expressionBesoinService.getNumberOfExpressionBesoinEnAttente();
        }

        @GetMapping("/getNumbersOrderByMonth")
        List<BigDecimal> getNumbersOrderByMonth(String month) {
            return expressionBesoinService.getNumbersOrderByMonth(month);
        }

        @GetMapping("/monthv2")
        public List<String> graph_monsuel(String e1, String e2, String e3, String e4, String e5, String e6, String e7, String e8, String e9, String e10, String e11, String e12) {
            return expressionBesoinService.graph_monsuel(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);
        }
        //
}
