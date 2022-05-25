package com.example.backadmin.ws;

import com.example.backadmin.bean.NaturePrestation;
import com.example.backadmin.service.facade.NaturePrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/nature-prestation")
public class NaturePrestationWs {

    @GetMapping("/reference/{reference}")
    public NaturePrestation findByReference(@PathVariable String reference) {
        return naturePrestationService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return naturePrestationService.deleteByReference(reference);
    }

    @GetMapping("/nature-prestation-type/reference/{reference}")
    public List<NaturePrestation> findByNaturePrestationTypeReference(@PathVariable String reference) {
        return naturePrestationService.findByNaturePrestationTypeReference(reference);
    }

    @GetMapping("/")
    public List<NaturePrestation> findAll() {
        return naturePrestationService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody NaturePrestation naturePrestation) {
        return naturePrestationService.save(naturePrestation);
    }

    @Autowired
    NaturePrestationService naturePrestationService;
}
