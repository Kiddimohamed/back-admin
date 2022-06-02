package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Paragraphe;

import java.util.List;

public interface ParagrapheService {

    Paragraphe findByReference(String reference);

    int deleteByReference(String reference);

    List<Paragraphe> findByArticleReference(String reference);

    List<Paragraphe> findAll();

    int save(Paragraphe paragraphe);
}
