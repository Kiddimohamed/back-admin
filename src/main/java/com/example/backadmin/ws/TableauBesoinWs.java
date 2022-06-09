package com.example.backadmin.ws;

import com.example.backadmin.bean.TableauBesoin;
import com.example.backadmin.service.facade.TableauBesoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/tableau-besoin")
public class TableauBesoinWs {
    @PostMapping("/")
    public void save(@RequestBody TableauBesoin tableauBesoin) {
        tableauBesoinService.save(tableauBesoin);
    }

    @GetMapping("/statut/{statut}")
    public List<TableauBesoin> findByStatut(String statut) {
        return tableauBesoinService.findByStatut(statut);
    }

    @GetMapping("/")
    public List<TableauBesoin> findAll() {
        return tableauBesoinService.findAll();
    }

    @Autowired
    private TableauBesoinService tableauBesoinService;
}
