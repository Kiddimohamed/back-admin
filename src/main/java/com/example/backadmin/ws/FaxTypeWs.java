package com.example.backadmin.ws;

import com.example.backadmin.bean.Fax;
import com.example.backadmin.bean.FaxType;
import com.example.backadmin.service.facade.FaxService;
import com.example.backadmin.service.facade.FaxTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/fax-type")
public class FaxTypeWs {

    @GetMapping("/code/{code}")
    public FaxType findByCode(@PathVariable String code) {
        return faxTypeService.findByCode(code);
    }
    @GetMapping("/libelle/{libelle}")
    public FaxType findByLibelle(@PathVariable String libelle) {
        return faxTypeService.findByLibelle(libelle);
    }

    @GetMapping("/")
    public List<FaxType> findAll() {
        return faxTypeService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody FaxType faxType) {
        return faxTypeService.save(faxType);
    }

    @Autowired
    FaxTypeService faxTypeService;
}
