package com.example.backadmin.service.impl;

import com.example.backadmin.bean.ExpressionBesoinItem;
import com.example.backadmin.bean.*;
import com.example.backadmin.dao.ExpressionBesoinItemDao;
import com.example.backadmin.service.facade.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpressionBesoinItemServiceImpl implements ExpressionBesoinItemService {

    @Override
    public ExpressionBesoinItem findByRef(String ref) {
        return expressionBesoinItemDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return expressionBesoinItemDao.deleteByRef(ref);
    }

    @Override
    public List<ExpressionBesoinItem> findByExpressionBesoinReference(String reference) {
        return expressionBesoinItemDao.findByExpressionBesoinReference(reference);
    }

    @Override
    public List<ExpressionBesoinItem> findByStatut(String statut) {
        return expressionBesoinItemDao.findByStatut(statut);
    }

    @Override
    public List<ExpressionBesoinItem> findByTableauBesoinItemRef(String ref) {
        TableauBesoinItem tableauBesoinItem = tableauBesoinItemService.findByReference(ref);
        return expressionBesoinItemDao.findByTableauBesoinReference(tableauBesoinItem.getTableauBesoin().getReference());
    }

    @Override
    public List<ExpressionBesoinItem> findAll() {
        return expressionBesoinItemDao.findAll();
    }

    @Override
    public ExpressionBesoinItem findByCode(String code) {
        return expressionBesoinItemDao.findByCode(code);
    }

    @Override
    public List<ExpressionBesoinItem> findByTableauBesoinReference(String reference) {
        return expressionBesoinItemDao.findByTableauBesoinReference(reference);
    }

    @Override
    public List<ExpressionBesoinItem> findByExpressionBesoinObjet(String objet) {
        return expressionBesoinItemDao.findByExpressionBesoinObjet(objet);
    }

    @Override
    public int updateStatut(ExpressionBesoinItem expressionBesoinItem) {
        ExpressionBesoinItem expressionBesoinItem1 = expressionBesoinItemDao.findByRef(expressionBesoinItem.getRef());
        expressionBesoinItem1.setStatut(expressionBesoinItem.getStatut());
        expressionBesoinItemDao.save(expressionBesoinItem1);
        return 1;
    }

    @Override
    public int updateTableauBesoin(ExpressionBesoinItem expressionBesoinItem) {
        ExpressionBesoinItem expressionBesoinItem1 = expressionBesoinItemDao.findByRef(expressionBesoinItem.getRef());
        TableauBesoin tableauBesoin = tableauBesoinService.findByReference(expressionBesoinItem.getTableauBesoin().getReference());
        expressionBesoinItem1.setTableauBesoin(tableauBesoin);
        expressionBesoinItemDao.save(expressionBesoinItem1);
        return 1;
    }

    @Override
    public int save(ExpressionBesoinItem expressionBesoinItem) {
        expressionBesoinItem.setRefExpr(expressionBesoinItem.getExpressionBesoin().getReference());
        if (expressionBesoinItem.getQuantite() <= 0) {
            return -1;
        } else {
            expressionBesoinItem.setLibelle(expressionBesoinItem.getProduit().getLibelle());
            expressionBesoinItemDao.save(expressionBesoinItem);
            return 1;
        }
    }

    @Override
    public String imprimer(String objet) throws FileNotFoundException, JRException {
        List<ExpressionBesoinItem> expressionBesoinItems = findByExpressionBesoinObjet(objet);
        ExpressionBesoin byObjet = expressionBesoinService.findByObjet(objet);
//        System.out.println(78888);
//        System.out.println(byRef.getObjet());
        File file = ResourceUtils.getFile("classpath:Reports\\ExpressionDeBesoin.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource datesource = new JRBeanCollectionDataSource(expressionBesoinItems);
        Map<String, Object> parametres = new HashMap<String, Object>();
        parametres.put("objet", byObjet.getObjet());
        parametres.put("dateExb", byObjet.getDateExb());
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parametres, datesource);

        JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\LENOVO\\Desktop\\rapport\\Expresion_besoin_" + byObjet.getReference() + "_" + byObjet.getObjet() + ".pdf");
        return "hahahah";
    }

    @Override
    public void updatePrix(ExpressionBesoinItem expressionBesoinItem) {
        ExpressionBesoinItem expressionBesoinItem1 = expressionBesoinItemDao.findByRef(expressionBesoinItem.getRef());
        expressionBesoinItem1.setPU(expressionBesoinItem.getPU());
        expressionBesoinItem1.setPT((expressionBesoinItem.getPU()) * (expressionBesoinItem.getQuantite()));
        expressionBesoinItemDao.save(expressionBesoinItem1);
    }

    @Override
    public List<ExpressionBesoinItem> findByExpressionBesoinStatut(String statut) {
        return expressionBesoinItemDao.findByExpressionBesoinStatut(statut);
    }

    @Override
    public Long getMaxId() {
        return expressionBesoinItemDao.getMaxId();
    }

    @Autowired
    private ExpressionBesoinItemDao expressionBesoinItemDao;
    @Autowired
    private ExpressionBesoinService expressionBesoinService;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private TableauBesoinService tableauBesoinService;
    @Autowired
    private TableauBesoinItemService tableauBesoinItemService;

}
