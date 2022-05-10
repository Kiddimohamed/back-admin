package com.example.backadmin.ws;

import com.example.backadmin.bean.Etablissement;
import com.example.backadmin.service.facade.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/etablissement")
public class EtablissementWs {
    @GetMapping("/reference/{reference}")
    public Etablissement findByReference(@PathVariable String reference) {
        return etablissementService.findByReference(reference);
    }

    // TODO ville bean non pas String
    @GetMapping("/ville/{ville}")
    public Etablissement findByVille(@PathVariable String ville) {
        return etablissementService.findByVille(ville);
    }

    @GetMapping("/")
    public List<Etablissement> findAll() {
        return etablissementService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Etablissement etablissement) {
        return etablissementService.save(etablissement);
    }

    @Autowired
    EtablissementService etablissementService;
}
