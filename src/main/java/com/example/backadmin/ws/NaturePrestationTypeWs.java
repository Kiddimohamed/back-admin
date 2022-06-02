package com.example.backadmin.ws;

import com.example.backadmin.bean.NaturePrestation;
import com.example.backadmin.bean.NaturePrestationType;
import com.example.backadmin.service.facade.NaturePrestationService;
import com.example.backadmin.service.facade.NaturePrestationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/nature-prestation-type")
public class NaturePrestationTypeWs {

    @GetMapping("/reference/{reference}")
    public NaturePrestationType findByReference(@PathVariable String reference) {
        return naturePrestationTypeService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return naturePrestationTypeService.deleteByReference(reference);
    }

    @GetMapping("/")
    public List<NaturePrestationType> findAll() {
        return naturePrestationTypeService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody NaturePrestationType naturePrestationType) {
        return naturePrestationTypeService.save(naturePrestationType);
    }

    @Autowired
    NaturePrestationTypeService naturePrestationTypeService;
}
