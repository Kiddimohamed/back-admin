package com.example.backadmin.ws;

import com.example.backadmin.bean.Ligne;
import com.example.backadmin.service.facade.LigneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/ligne")
public class LigneWs {

    @GetMapping("/reference/{reference}")
    public Ligne findByReference(@PathVariable String reference) {

        return ligneService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return ligneService.deleteByReference(reference);
    }


    @GetMapping("/nature-prestation/reference/{reference}")
    public List<Ligne> findByNaturePrestationReference(@PathVariable String reference) {
        return ligneService.findByNaturePrestationReference(reference);
    }

    @GetMapping("/paragraphe/reference/{reference}")
    public List<Ligne> findByParagrapheReference(@PathVariable String reference) {
        return ligneService.findByParagrapheReference(reference);
    }

    @GetMapping("/")
    public List<Ligne> findAll() {
        return ligneService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Ligne ligne) {
        return ligneService.save(ligne);
    }

    @Autowired
    LigneService ligneService;
}
