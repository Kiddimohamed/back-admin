package com.example.backadmin.service.impl;

import com.example.backadmin.service.facade.ReportService;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    public String imprimerFax(String referenceEmploye,String referenceFournisseur,String referenceEtablissement){
    return "okey";
    }
}
