package com.example.backadmin.ws;

import com.example.backadmin.bean.TableauBesoinItem;
import com.example.backadmin.service.facade.TableauBesoinItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/tableau-besoin-item")
public class TableauBesoinItemWs {
    @GetMapping("/statut/tableauBesoin/reference/{statut}/{reference}")
    public List<TableauBesoinItem> findByStatutAndTableauBesoinReference(@PathVariable String statut, @PathVariable String reference) {
        return tableauBesoinItemService.findByStatutAndTableauBesoinReference(statut, reference);
    }

    @PutMapping("/update/statut")
    public void updateStatut(@RequestBody TableauBesoinItem tableauBesoinItem) {
        tableauBesoinItemService.updateStatut(tableauBesoinItem);
    }

    @PostMapping("/")
    public TableauBesoinItem save(@RequestBody TableauBesoinItem tableauBesoinItem) {
        return tableauBesoinItemService.save(tableauBesoinItem);
    }

    @GetMapping("/tableauBesoin/statut/{statut}")
    public List<TableauBesoinItem> findByTableauBesoinStatut(String statut) {
        return tableauBesoinItemService.findByTableauBesoinStatut(statut);
    }

    @GetMapping("/reference/{reference}")
    public TableauBesoinItem findByReference(@PathVariable String reference) {
        return tableauBesoinItemService.findByReference(reference);
    }

    @GetMapping("/statut/{statut}")
    public List<TableauBesoinItem> findByStatut(@PathVariable String statut) {
        return tableauBesoinItemService.findByStatut(statut);
    }

    @GetMapping("/tableauBesoin/fournisseur/{tabRef}/{fournisseurRef}")
    public TableauBesoinItem findByTableauBesoinReferenceAndFournisseurReferenceFournisseur(@PathVariable String tabRef, @PathVariable String fournisseurRef) {
        return tableauBesoinItemService.findByTableauBesoinReferenceAndFournisseurReferenceFournisseur(tabRef, fournisseurRef);
    }

    @GetMapping("/tableauBesoin/reference/{reference}")
    public List<TableauBesoinItem> findByTableauBesoinReference(@PathVariable String reference) {
        return tableauBesoinItemService.findByTableauBesoinReference(reference);
    }

    @Autowired
    private TableauBesoinItemService tableauBesoinItemService;
}
