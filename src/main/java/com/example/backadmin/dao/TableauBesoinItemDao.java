package com.example.backadmin.dao;

import com.example.backadmin.bean.TableauBesoin;
import com.example.backadmin.bean.TableauBesoinItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableauBesoinItemDao extends JpaRepository<TableauBesoinItem,Long> {
    TableauBesoinItem findByReference(String reference);
    List<TableauBesoinItem> findByStatut(String statut);
    List<TableauBesoinItem> findByTableauBesoinReference(String reference);
}
