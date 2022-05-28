package com.example.backadmin.service.impl;

import com.example.backadmin.bean.TableauBesoin;
import com.example.backadmin.dao.ExpressionBesoinItemDao;
import com.example.backadmin.dao.TableauBesoinDao;
import com.example.backadmin.service.facade.TableauBesoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TableauBesoinServiceImpl implements TableauBesoinService {
    @Override
    public TableauBesoin findByReference(String reference) {
        return tableauBesoinDao.findByReference(reference);
    }
    @Override
    public int save(TableauBesoin tableauBesoin){
        TableauBesoin tableauBesoin1=tableauBesoinDao.findByReference(tableauBesoin.getReference());
        if (tableauBesoin1!=null)return -1;
        else{
            tableauBesoin.setDateTableauBesoin(LocalDateTime.now());
            tableauBesoinDao.save(tableauBesoin);
            tableauBesoin.getExpressionBesoinItems().forEach(expressionBesoinItem -> {
                expressionBesoinItem.setStatut("envoyée");

            });

        }
    return 1;}
    @Autowired
    private TableauBesoinDao tableauBesoinDao;
    @Autowired
    private ExpressionBesoinItemDao expressionBesoinItemDao;
}
