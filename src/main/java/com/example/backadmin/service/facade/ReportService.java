package com.example.backadmin.service.facade;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface ReportService {
    String imprimerFax(String referenceFax) throws FileNotFoundException, JRException;

    String imprimerCommande(String commandeCode) throws FileNotFoundException, JRException;

    String imprimerReception(String receptionReference) throws FileNotFoundException, JRException;
}
