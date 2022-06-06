package com.example.backadmin.dao;

import com.example.backadmin.bean.TableauBesoin;
import com.example.backadmin.bean.TableauBesoinItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableauBesoinItemDao extends JpaRepository<TableauBesoinItem,Long> {
    TableauBesoinItem findByReference(String reference);
}
