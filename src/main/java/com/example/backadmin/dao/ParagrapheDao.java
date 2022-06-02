package com.example.backadmin.dao;

import com.example.backadmin.bean.Commande;
import com.example.backadmin.bean.Paragraphe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParagrapheDao extends JpaRepository<Paragraphe,Long> {
    Paragraphe findByReference(String reference);
    int deleteByReference(String reference);

    List<Paragraphe> findByArticleReference(String reference);

}
