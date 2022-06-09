package com.example.backadmin.ws;

import com.example.backadmin.bean.TableauBesoinItem;
import com.example.backadmin.service.facade.TableauBesoinItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/tableau-besoin-item")
public class TableauBesoinItemWs {
    @PostMapping("/")
    public int save(@RequestBody TableauBesoinItem tableauBesoinItem) {
        return tableauBesoinItemService.save(tableauBesoinItem);
    }
    @GetMapping("/reference/{reference}")
    public TableauBesoinItem findByReference(@PathVariable String reference) {
        return tableauBesoinItemService.findByReference(reference);
    }




    @GetMapping("/tableau-besoin/{reference}")
    public List<TableauBesoinItem> findByTableauBesoinReference(@PathVariable String reference) {
        return tableauBesoinItemService.findByTableauBesoinReference(reference);
    }
    @GetMapping("/statut/{statut}")
    public List<TableauBesoinItem> findByStatut(@PathVariable String statut) {
        return tableauBesoinItemService.findByStatut(statut);
    }

    @Autowired
    private TableauBesoinItemService tableauBesoinItemService;
}
