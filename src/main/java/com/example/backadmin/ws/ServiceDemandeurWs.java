package com.example.backadmin.ws;

import com.example.backadmin.bean.ServiceDemandeur;
import com.example.backadmin.service.facade.ServiceDemandeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/service-demandeur")
public class ServiceDemandeurWs {

    @GetMapping("/reference/{reference}")
    public ServiceDemandeur findByReference(@PathVariable String reference) {
        return serviceDemandeurService.findByReference(reference);
    }

//    @GetMapping("/etablissement/reference/{reference}")
//    public ServiceDemandeur findByEtablissementReference(@PathVariable String reference) {
//        return serviceDemandeurService.findByEtablissementReference(reference);
//    }

    @GetMapping("/")
    public List<ServiceDemandeur> findAll() {
        return serviceDemandeurService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody ServiceDemandeur serviceDemandeur) {
        return serviceDemandeurService.save(serviceDemandeur);
    }

    @Autowired
    ServiceDemandeurService serviceDemandeurService;
}
