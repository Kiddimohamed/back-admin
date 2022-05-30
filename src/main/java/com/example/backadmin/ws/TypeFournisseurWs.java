package com.example.backadmin.ws;

import com.example.backadmin.bean.TypeFournisseur;
import com.example.backadmin.service.facade.TypeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/type-fournisseur")
public class TypeFournisseurWs {
    @GetMapping("/reference/{reference}")
    public TypeFournisseur findByReference(@PathVariable String reference) {
        return typeFournisseurService.findByReference(reference);
    }

    @GetMapping("/type/{type}")
    public TypeFournisseur findByType(@PathVariable String type) {
        return typeFournisseurService.findByType(type);
    }

    @GetMapping("/")
    public List<TypeFournisseur> findAll() {
        return typeFournisseurService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody TypeFournisseur typeFournisseur) {
        return typeFournisseurService.save(typeFournisseur);
    }

    @Autowired
    private TypeFournisseurService typeFournisseurService;
}
