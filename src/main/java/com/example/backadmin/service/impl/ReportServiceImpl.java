package com.example.backadmin.service.impl;

import com.example.backadmin.bean.*;
import com.example.backadmin.service.facade.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public String imprimerFax(String referenceFax) throws FileNotFoundException, JRException {
        Fax fax= faxService.findByReferenceFax(referenceFax);
        List<Fax> fc = faxService.findAll();
//        Etablissement etablissement= etablissementService.findByReference(fax.getEmetteur().getEtablissement().getReference());
        Etablissement etablissement= etablissementService.findByReference(fax.getEmetteur().getEtablissement().getReference());
        File file = ResourceUtils.getFile("classpath:Reports\\Fax.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource datesource = new JRBeanCollectionDataSource(fc);
        Map<String, Object> parametres = new HashMap<String, Object>();
        parametres.put("ville", etablissement.getVille());
        parametres.put("dateFax", fax.getDateFax());
        parametres.put("nomEmploye", fax.getEmetteur().getNomEmploye());
        parametres.put("nomFournisseur", fax.getFournisseur().getNomFournisseur());
        parametres.put("telephoneEmploye", fax.getEmetteur().getTelephoneEmploye());
        parametres.put("faxEmploye", fax.getEmetteur().getFaxEmploye());
        parametres.put("telephoneFournisseur", fax.getFournisseur().getTelephoneFournisseur());
        parametres.put("faxFournisseur", fax.getFournisseur().getFaxFournisseur());
        parametres.put("objetFax", fax.getObjetFax());
        parametres.put("adresse", etablissement.getAdresse());
        parametres.put("telephone", etablissement.getTelephone());
        parametres.put("fax", etablissement.getFax());
        parametres.put("email", etablissement.getEmail());
        parametres.put("siteWeb", etablissement.getSiteWeb());
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parametres,datesource);
        JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\Hp\\Desktop" + "\\Fax_" + fax.getReferenceFax() + "_" + fax.getFournisseur().getNomFournisseur() + ".pdf");


        return "okey";
    }



    @Override
    public String imprimerCommande(String commandeCode) throws FileNotFoundException, JRException {
        List<CommandeItem> data =commandeItemService.findByCommandeCode(commandeCode);
        Commande commande=commandeService.findByCode(commandeCode);
        File file = ResourceUtils.getFile("classpath:Reports\\BonDeCommande.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource datesource = new JRBeanCollectionDataSource(data);
        Map<String, Object> parametres = new HashMap<String, Object>();
        parametres.put("exercice", commande.getExercice());
        parametres.put("chapitre", commande.getChapitre());
        parametres.put("article", commande.getArticle());
        parametres.put("paragraphe", commande.getParagraphe());
        parametres.put("ligne", commande.getLigne());
        parametres.put("natureDePrestation", commande.getNaturePrestation());
        parametres.put("raisonSocial", commande.getRaisonSociale());
        parametres.put("adresse",commande.getAdresse());
        parametres.put("dateCommande", commande.getDateCommande());
        parametres.put("totalTtc", commande.getTotalTtc());
        parametres.put("totalHt", commande.getTotalHt());
        parametres.put("tva",commande.getTVA());
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parametres,datesource);
        JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\Hp\\Desktop" + "\\BonDeCommande_" + commande.getCode() + "_" + commande.getExpressionBesoin().getReference() + ".pdf");


        return "okey";
    }

    @Autowired
    FournisseurService fournisseurService;
    @Autowired
    FaxService faxService;
    @Autowired
    EtablissementService etablissementService;
    @Autowired
    CommandeItemService commandeItemService;
    @Autowired
    CommandeService commandeService;
    @Autowired
    EmployeService employeService;
}
