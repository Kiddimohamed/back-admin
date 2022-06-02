package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Article;
import com.example.backadmin.bean.Paragraphe;
import com.example.backadmin.dao.ArticleDao;
import com.example.backadmin.dao.ParagrapheDao;
import com.example.backadmin.service.facade.ParagrapheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ParagrapheServiceImpl implements ParagrapheService {

    @Override
    public Paragraphe findByReference(String reference) {
        return paragrapheDao.findByReference(reference);
    }

    @Transactional
    @Override
    public int deleteByReference(String reference) {
        return paragrapheDao.deleteByReference(reference);
    }

    @Override
    public List<Paragraphe> findByArticleReference(String reference) {
        return paragrapheDao.findByArticleReference(reference);
    }

    @Override
    public List<Paragraphe> findAll() {
        return paragrapheDao.findAll();
    }

    @Override
    public  int save(Paragraphe paragraphe){
        Paragraphe paragraphe1=findByReference(paragraphe.getReference());
        prepare(paragraphe);
        if (paragraphe1!=null){
            return -1;
        }else if(paragraphe.getArticle()==null){
            return -2;
        }else{
            paragraphe.setLibelleArticle(paragraphe.getArticle().getCode());
            paragraphe.setLibelleChapitre(paragraphe.getArticle().getLibelleChapitre());
            paragrapheDao.save(paragraphe);
            return 1;
        }
    }

    private void prepare(Paragraphe paragraphe) {
        Article article=articleDao.findByReference(paragraphe.getArticle().getReference());
        paragraphe.setArticle(article);
    }

    @Autowired
    ArticleDao articleDao;
    @Autowired
    ParagrapheDao paragrapheDao;
}
