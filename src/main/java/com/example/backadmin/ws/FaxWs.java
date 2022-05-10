package com.example.backadmin.ws;

import com.example.backadmin.bean.Fax;
import com.example.backadmin.service.facade.FaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/fax")
public class FaxWs {
    @GetMapping("/reference/{reference}")
    public Fax findByReference(@PathVariable String reference) {
        return faxService.findByReference(reference);
    }

    @GetMapping("/expression-besoin/reference/{reference}")
    public Fax findByExpressionBesoinReference(@PathVariable String reference) {
        return faxService.findByExpressionBesoinReference(reference);
    }

    @GetMapping("/fournisseur/reference/{reference}")
    public List<Fax> findByFournisseurReference(@PathVariable String reference) {
        return faxService.findByFournisseurReference(reference);
    }

    @GetMapping("/fax-type/code/{code}")
    public List<Fax> findByFaxTypeCode(@PathVariable String code) {
        return faxService.findByFaxTypeCode(code);
    }

    @GetMapping("/")

    public List<Fax> findAll() {
        return faxService.findAll();
    }

    @PostMapping("/")

    public int save(@RequestBody Fax fax) {
        return faxService.save(fax);
    }

    @Autowired
    FaxService faxService;
}
