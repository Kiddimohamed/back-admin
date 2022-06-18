package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Article;

import java.util.List;

public interface ArticleService {
    Article findByReference(String reference);

    int deleteByReference(String reference);

    List<Article> findByChapitreReference(String reference);
    List<Article> findByLibelleChapitre(String libelleChapitre);

    List<Article> findAll();

    int save(Article article);
}
