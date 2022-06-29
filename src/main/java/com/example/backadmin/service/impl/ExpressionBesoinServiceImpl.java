package com.example.backadmin.service.impl;
import com.example.backadmin.bean.ExpressionBesoin;
import com.example.backadmin.bean.NatureDemande;
import com.example.backadmin.dao.ExpressionBesoinDao;
import com.example.backadmin.security.bean.User;
import com.example.backadmin.security.service.facade.UserService;
import com.example.backadmin.service.facade.ExpressionBesoinItemService;
import com.example.backadmin.service.facade.ExpressionBesoinService;
import com.example.backadmin.service.facade.NatureDemandeService;
import com.example.backadmin.service.facade.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpressionBesoinServiceImpl implements ExpressionBesoinService {


    @Override
    public ExpressionBesoin findByReference(String reference) {
        return expressionBesoinDao.findByReference(reference);
    }

    @Override
    public ExpressionBesoin findByObjet(String objet) {
        return expressionBesoinDao.findByObjet(objet);
    }

    @Override
    public ExpressionBesoin findByDateExb(LocalDateTime date) {
        return expressionBesoinDao.findByDateExb(date);
    }

    @Override
    public List<ExpressionBesoin> findByUserReference(String reference) {
        return expressionBesoinDao.findByUserReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return expressionBesoinDao.deleteByReference(reference);
    }

    @Override
    public List<ExpressionBesoin> findAll() {
        return expressionBesoinDao.findAll();
    }


    @Override
    public List<ExpressionBesoin> findByStatutAndUserUsername(String statut, String username) {
        return expressionBesoinDao.findByStatutAndUserUsername(statut, username);
    }

    @Override
    public List<ExpressionBesoin> findByStatut(String statut) {
        return expressionBesoinDao.findByStatut(statut);
    }

    @Override
    public int save(ExpressionBesoin expressionBesoin) {
        prepare(expressionBesoin);
        int res = validate(expressionBesoin);
        if (res > 0) {

            handelprocess(expressionBesoin);
            return 1;
        } else return res;

    }


    public void increment(ExpressionBesoin expressionBesoin) {
        int i;

    }

    private void prepare(ExpressionBesoin expressionBesoin) {
        User user = userService.findByReference(expressionBesoin.getUser().getReference());
        expressionBesoin.setUser(user);

        NatureDemande natureDemande= natureDemandeService.findByNom(expressionBesoin.getNatureDemande().getNom());
        expressionBesoin.setNatureDemande(natureDemande);
//        expressionBesoin.getExpressionBesoinItems().forEach(e -> {
//
//            e.setExpressionBesoin(expressionBesoin);
//            e.setProduit(e.getProduit());
//
//        });
    }


    private int validate(ExpressionBesoin expressionBesoin) {
        ExpressionBesoin expressionBesoin1 = findByReference(expressionBesoin.getReference());

        if (expressionBesoin1 != null) {
            return -3;

        } else {
            return 1;
        }
    }

    @Override
    public String getRefExpressionBesoin(ExpressionBesoin expressionBesoin) {
        return expressionBesoin.getReference();
    }




    public void handelprocess(ExpressionBesoin expressionBesoin) {
        expressionBesoin.setDateExb(LocalDateTime.now());
        expressionBesoin.setMonth(LocalDateTime.now().getMonth().toString());
        expressionBesoin.setReference("Exb-" + (getMaxId() + 1));
        expressionBesoinDao.save(expressionBesoin);

        expressionBesoin.getExpressionBesoinItems().forEach(expressionBesoinItem -> {
            produitService.save(expressionBesoinItem.getProduit());
            //Produit produit = produitService.findByLibelle(expressionBesoinItem.getProduit().getLibelle());
            expressionBesoinItem.setExpressionBesoin(expressionBesoin);
            //expressionBesoinItem.setProduit(produit);
            expressionBesoinItem.setRef("ExpI-" + getMaxId() + "-" + (expressionBesoinItemService.getMaxId() + 1));
            expressionBesoinItemService.save(expressionBesoinItem);
        });
    }

    public Long getMaxId() {
        return expressionBesoinDao.getMaxId();
    }

    public void updateExpressionBesoin(ExpressionBesoin expressionBesoin) {

        ExpressionBesoin e = expressionBesoinDao.findByReference(expressionBesoin.getReference());
        e.setStatut("En cours");
        expressionBesoinDao.save(e);
    }

    @Override
    public void refuser(ExpressionBesoin expressionBesoin) {
        ExpressionBesoin e = expressionBesoinDao.findByReference(expressionBesoin.getReference());
        e.setStatut("Archivée");
        expressionBesoinDao.save(e);
    }
    @Override
    public List<ExpressionBesoin> findByNatureDemandeNom(String nom) {
        return expressionBesoinDao.findByNatureDemandeNom(nom);
    }




    //statistique
    public int getNumberOfExpressionBesoinEnAttente(){
        return expressionBesoinDao.getNumberOfExpressionBesoinEnAttente();
    }

    @Autowired
    protected EntityManager entityManager;





    public List<BigDecimal> getNumbersOrderByMonth(String month){

        String query = "SELECT COUNT(e.id) FROM ExpressionBesoin e where E.month like :month group by e.month " ;

        return entityManager.createQuery(query).getResultList();     }


    public List<String> graph_monsuel(String e1, String e2, String e3, String e4, String e5, String e6, String e7, String e8, String e9, String e10, String e11, String e12) {
        List<String> expr_mois = new ArrayList<>();
        expr_mois.add(expressionBesoinDao.exp_par_mois(e1));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e2));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e3));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e4));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e5));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e6));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e7));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e8));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e9));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e10));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e11));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e12));
        return expr_mois;

    }


    @Autowired
    private ExpressionBesoinDao expressionBesoinDao;

    @Autowired
    private UserService userService;


    @Autowired
    ProduitService produitService;

    @Autowired
    private ExpressionBesoinItemService expressionBesoinItemService;

    @Autowired
    NatureDemandeService natureDemandeService;
}
