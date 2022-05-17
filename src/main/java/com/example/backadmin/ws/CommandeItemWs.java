package com.example.backadmin.ws;

import com.example.backadmin.bean.CommandeItem;
import com.example.backadmin.service.facade.CommandeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/commande-item")
public class CommandeItemWs {
    @GetMapping("/commande/code/{code}")
    public List<CommandeItem> findByCommandeCode(@PathVariable String code) {
        return commandeItemService.findByCommandeCode(code);
    }

    @GetMapping("/")
    public List<CommandeItem> findAll() {
        return commandeItemService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody CommandeItem commandeItem) {
        return commandeItemService.save(commandeItem);
    }

    @GetMapping("/code/{code}")
    public CommandeItem findByCode(@PathVariable String code) {
        return commandeItemService.findByCode(code);
    }

    @Autowired
    CommandeItemService commandeItemService;
}
