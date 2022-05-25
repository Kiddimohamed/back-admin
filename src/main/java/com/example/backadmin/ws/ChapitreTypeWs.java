package com.example.backadmin.ws;

import com.example.backadmin.bean.ChapitreType;
import com.example.backadmin.service.facade.ChapitreTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/chapitre-type")
public class ChapitreTypeWs {

    @GetMapping("/reference/{reference}")
    public ChapitreType findByReference(@PathVariable String reference) {
        return chapitreTypeService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return chapitreTypeService.deleteByReference(reference);
    }

    @GetMapping("/")
    public List<ChapitreType> findAll() {
        return chapitreTypeService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody ChapitreType chapitreType) {
        return chapitreTypeService.save(chapitreType);
    }

    @Autowired
    ChapitreTypeService chapitreTypeService;
}
