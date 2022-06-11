package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Paragraphe;

import java.util.List;

public interface ParagrapheService {

    Paragraphe findByReference(String reference);

    int deleteByReference(String reference);

    List<Paragraphe> findByArticleReference(String reference);

    List<Paragraphe> findAll();
    List<Paragraphe> findByLibelleArticle(String libelleArticle);

    int save(Paragraphe paragraphe);
}
