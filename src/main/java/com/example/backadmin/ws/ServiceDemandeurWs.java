package com.example.backadmin.ws;

import com.example.backadmin.bean.ServiceDemandeur;
import com.example.backadmin.service.facade.ServiceDemandeurService;
import com.example.backadmin.ws.converter.ServiceDemandeurConverter;
import com.example.backadmin.ws.provide.ServiceDemandeurVo;
import io.swagger.annotations.ApiOperation;
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
    @GetMapping("/nom/{nom}")
    public ServiceDemandeur findByNom(@PathVariable String nom) {
        return serviceDemandeurService.findByNom(nom);
    }


    //    @GetMapping("/etablissement/reference/{reference}")
//    public ServiceDemandeur findByEtablissementReference(@PathVariable String reference) {
//        return serviceDemandeurService.findByEtablissementReference(reference);
//    }
//    @DeleteMapping("/")
//    public void delete(@RequestBody ServiceDemandeur serviceDemandeur) {
//        serviceDemandeurService.delete(serviceDemandeur);
//    }


    //    @DeleteMapping("/reference/{reference}")
//    public int deleteByReference(@PathVariable String reference) {
//        return serviceDemandeurService.deleteByReference(reference);
//    }

    @PutMapping("/update/nom/{nom}")
    public void updateService(@RequestBody ServiceDemandeur serviceDemandeur,@PathVariable String nom) {
        serviceDemandeurService.updateService(serviceDemandeur,nom);
    }

    @DeleteMapping("/reference/{reference}")
    public void deleteByReference(@PathVariable String reference) {
        serviceDemandeurService.deleteByReference(reference);
    }


    @PostMapping("/")
    public int save(@RequestBody ServiceDemandeur serviceDemandeur) {
        return serviceDemandeurService.save(serviceDemandeur);
    }

    @Autowired
    ServiceDemandeurService serviceDemandeurService;
    @Autowired
    private ServiceDemandeurConverter serviceDemandeurConverter;
    //microservice
    @ApiOperation("service user")
    @GetMapping("/")
    public List<ServiceDemandeurVo> findAll() {
        return  serviceDemandeurConverter.toVo(serviceDemandeurService.findAll());
    }

}
