package com.example.backadmin.ws;

import com.example.backadmin.service.facade.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/v1/admin/imprimer")
public class ReportWs {
    @GetMapping("/fax/reference-fax/{referenceFax}")
    public String imprimerFax(@PathVariable String referenceFax) throws JRException, FileNotFoundException {
        return reportService.imprimerFax(referenceFax);
    }

    @Autowired
    ReportService reportService;
}
