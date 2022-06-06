package com.example.backadmin.ws;

import com.example.backadmin.bean.TableauBesoinItem;
import com.example.backadmin.service.facade.TableauBesoinItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/tableau-besoin-item")
public class TableauBesoinItemWs {
    @GetMapping("/reference/{reference}")
    public TableauBesoinItem findByReference(@PathVariable String reference) {
        return tableauBesoinItemService.findByReference(reference);
    }

    @GetMapping("/")
    public List<TableauBesoinItem> findAll() {
        return tableauBesoinItemService.findAll();
    }

    @GetMapping("/code/{code}")
    public List<TableauBesoinItem> findByExpressionBesoinItemCode(@PathVariable String code) {
        return tableauBesoinItemService.findByExpressionBesoinItemCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody TableauBesoinItem tableauBesoinItem) {
        return tableauBesoinItemService.save(tableauBesoinItem);
    }

    @PutMapping("/")
    public void update(@RequestBody TableauBesoinItem tableauBesoinItem) {
        tableauBesoinItemService.update(tableauBesoinItem);
    }

    @Autowired
    private TableauBesoinItemService tableauBesoinItemService;
}
