package com.example.backadmin.ws;

import com.example.backadmin.bean.TableauBesoin;
import com.example.backadmin.service.facade.TableauBesoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin/tableau-besoin")
public class TableauBesoinWs {

    @GetMapping("/reference/{reference}")
    public TableauBesoin findByReference(String reference) {
        return tableauBesoinService.findByReference(reference);
    }

    @PostMapping("/")
    public void save(TableauBesoin tableauBesoin) {
        tableauBesoinService.save(tableauBesoin);
    }

    @Autowired
    private TableauBesoinService tableauBesoinService;
}
