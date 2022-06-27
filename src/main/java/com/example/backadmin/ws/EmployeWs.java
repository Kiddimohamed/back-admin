package com.example.backadmin.ws;

import com.example.backadmin.bean.Employe;
import com.example.backadmin.service.facade.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/employe")
public class EmployeWs {
    @GetMapping("/reference/{reference}")
    public Employe findByReferenceEmploye(@PathVariable String reference) {
        return employeService.findByReferenceEmploye(reference);
    }

    @GetMapping("/nom/{nom}")
    public Employe findByNomEmploye(@PathVariable String nom) {
        return employeService.findByNomEmploye(nom);
    }

    @GetMapping("/etablissement/reference/{reference}")
    public List<Employe> findByEtablissementReference(@PathVariable String reference) {
        return employeService.findByEtablissementReference(reference);
    }

    @GetMapping("/")
    public List<Employe> findAll() {
        return employeService.findAll();
    }



    @PostMapping("/")
    public int save(@RequestBody Employe employe) {
        return employeService.save(employe);
    }

    @Autowired
    EmployeService employeService;
}
