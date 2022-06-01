package com.example.backadmin.ws;

import com.example.backadmin.bean.FournisseurItem;
import com.example.backadmin.service.facade.FournisseurItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/fournisseur-item")
public class FournisseurItemWs {
    @GetMapping("/type-fournisseur/reference/{reference}")
    public List<FournisseurItem> findByTypeFournisseurReference(@PathVariable String reference) {
        return fournisseurItemService.findByTypeFournisseurReference(reference);
    }

    @GetMapping("/")
    public List<FournisseurItem> findAll() {
        return fournisseurItemService.findAll();
    }

    @PostMapping("/")
    public FournisseurItem save(@RequestBody FournisseurItem fournisseurItem) {
        return fournisseurItemService.save(fournisseurItem);
    }

    @Autowired
    private FournisseurItemService fournisseurItemService;
}
