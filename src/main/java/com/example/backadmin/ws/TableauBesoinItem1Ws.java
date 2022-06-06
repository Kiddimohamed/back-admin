package com.example.backadmin.ws;

import com.example.backadmin.bean.TableauBesoinItem1;
import com.example.backadmin.service.facade.TableauBesoinItem1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/tableau-besoin-item1")
public class TableauBesoinItem1Ws {
    @GetMapping("/reference/{reference}")
    public TableauBesoinItem1 findByReference(@PathVariable String reference) {
        return tableauBesoinItemService.findByReference(reference);
    }

    @GetMapping("/")
    public List<TableauBesoinItem1> findAll() {
        return tableauBesoinItemService.findAll();
    }

    @GetMapping("/code/{code}")
    public List<TableauBesoinItem1> findByExpressionBesoinItemCode(@PathVariable String code) {
        return tableauBesoinItemService.findByExpressionBesoinItemCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody TableauBesoinItem1 tableauBesoinItem) {
        return tableauBesoinItemService.save(tableauBesoinItem);
    }

    @PutMapping("/")
    public void update(@RequestBody TableauBesoinItem1 tableauBesoinItem) {
        tableauBesoinItemService.update(tableauBesoinItem);
    }

    @Autowired
    private TableauBesoinItem1Service tableauBesoinItemService;
}
