package com.example.backadmin.ws;

import com.example.backadmin.bean.Paragraphe;
import com.example.backadmin.service.facade.ParagrapheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/paragraphe")
public class ParagrapheWs {

    @GetMapping("/reference/{reference}")
    public Paragraphe findByReference(@PathVariable String reference) {
        return paragrapheService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return paragrapheService.deleteByReference(reference);
    }

    @GetMapping("/article/reference/{reference}")
    public List<Paragraphe> findByArticleReference(@PathVariable String reference) {
        return paragrapheService.findByArticleReference(reference);
    }

    @GetMapping("/")
    public List<Paragraphe> findAll() {
        return paragrapheService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Paragraphe paragraphe) {
        return paragrapheService.save(paragraphe);
    }

    @Autowired
    ParagrapheService paragrapheService;
}
