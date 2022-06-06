package com.example.backadmin.ws;

import com.example.backadmin.bean.TableauBesoinItem;
import com.example.backadmin.service.facade.TableauBesoinItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin/tableau-besoin-item")
public class TableauBesoinItemWs {
    @PostMapping("/")
    public int save(@RequestBody TableauBesoinItem tableauBesoinItem) {
        return tableauBesoinItemService.save(tableauBesoinItem);
    }

    @Autowired
    private TableauBesoinItemService tableauBesoinItemService;
}
