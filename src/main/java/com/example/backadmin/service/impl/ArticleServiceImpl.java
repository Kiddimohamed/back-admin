package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Article;
import com.example.backadmin.bean.Chapitre;
import com.example.backadmin.dao.ArticleDao;
import com.example.backadmin.service.facade.ArticleService;
import com.example.backadmin.service.facade.ChapitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Override
    public Article findByReference(String reference) {
        return articleDao.findByReference(reference);
    }

    @Transactional
    @Override
    public int deleteByReference(String reference) {
        return articleDao.deleteByReference(reference);
    }

    @Override
    public List<Article> findByChapitreReference(String reference) {
        return articleDao.findByChapitreReference(reference);
    }

    @Override
    public List<Article> findAll() {
        return articleDao.findAll();
    }


   @Override
   public int save(Article article) {
        Article article1 = findByReference(article.getReference());
        prepare(article);

        if (article1 != null) {
            return -1;
        } else if (article.getChapitre().getReference() == null) {
            return -2;
        } else {
            articleDao.save(article);
            return 1;
        }

    }

    private void prepare(Article article) {
        Chapitre chapitre=chapitreService.findByReference(article.getChapitre().getReference());
        article.setChapitre(chapitre);
    }

    @Autowired
    ChapitreService chapitreService;
    @Autowired
    ArticleDao articleDao;
}
