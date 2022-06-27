package com.example.backadmin.ws;

import com.example.backadmin.bean.NatureDemande;
import com.example.backadmin.service.facade.NatureDemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centre-project/v1/nature-demande")
public class NatureDemandeWs {

    @GetMapping("/reference/{reference}")
    public NatureDemande findByRef(@PathVariable String reference) {
        return natureDemandeService.findByRef(reference);
    }

    @GetMapping("/nom/{nom}")
    public NatureDemande findByNom(@PathVariable String nom) {
        return natureDemandeService.findByNom(nom);
    }

    @GetMapping("/")
    public List<NatureDemande> findAll() {
        return natureDemandeService.findAll();
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByRef(@PathVariable String reference) {
        return natureDemandeService.deleteByRef(reference);
    }

    @DeleteMapping("/nom/{nom}")
    public int deleteByNom(@PathVariable String nom) {
        return natureDemandeService.deleteByNom(nom);
    }

    @PostMapping("/")
    public int save(@RequestBody NatureDemande natureDemande) {
        return natureDemandeService.save(natureDemande);
    }

    @Autowired
    private NatureDemandeService natureDemandeService;
}
