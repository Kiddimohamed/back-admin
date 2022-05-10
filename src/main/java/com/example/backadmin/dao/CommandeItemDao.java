package com.example.backadmin.dao;

import com.example.backadmin.bean.CommandeItem;
import com.example.backadmin.bean.ExpressionBesoinItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeItemDao extends JpaRepository<CommandeItem, Long> {

    List<CommandeItem> findByCommandeCode(String code);
    CommandeItem findByCode(String code);

}
