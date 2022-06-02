package com.example.backadmin.dao;

import com.example.backadmin.bean.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao extends JpaRepository<Article,Long> {
    Article findByReference(String reference);
    int deleteByReference(String reference);
     List<Article> findByChapitreReference(String reference);

}
