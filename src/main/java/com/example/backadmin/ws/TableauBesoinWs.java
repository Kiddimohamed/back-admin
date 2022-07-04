package com.example.backadmin.ws;

import com.example.backadmin.bean.TableauBesoin;
import com.example.backadmin.bean.TableauBesoinItem;
import com.example.backadmin.service.facade.TableauBesoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/tableau-besoin")
public class TableauBesoinWs {
    @PostMapping("/")
    public TableauBesoin save(@RequestBody TableauBesoin tableauBesoin) {
        return tableauBesoinService.save(tableauBesoin);
    }


    @GetMapping("/statut/{statut}")
    public List<TableauBesoin> findByStatut(@PathVariable String statut) {
        return tableauBesoinService.findByStatut(statut);
    }
    @PutMapping("/update/statut/{statut}")
    public void update(@RequestBody TableauBesoin tableauBesoin,@PathVariable String statut) {
        tableauBesoinService.update(tableauBesoin, statut);
    }



    public void setTableauBesoinService(TableauBesoinService tableauBesoinService) {
        this.tableauBesoinService = tableauBesoinService;
    }

    @GetMapping("/")
    public List<TableauBesoin> findAll() {
        return tableauBesoinService.findAll();
    }

    @Autowired
    private TableauBesoinService tableauBesoinService;
}
