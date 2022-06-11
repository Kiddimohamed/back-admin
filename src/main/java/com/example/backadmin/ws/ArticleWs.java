package com.example.backadmin.ws;


import com.example.backadmin.bean.Article;
import com.example.backadmin.service.facade.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/article")
public class ArticleWs {
    @GetMapping("/reference/{reference}")
    public Article findByReference(@PathVariable String reference) {
        return articleService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return articleService.deleteByReference(reference);
    }

    @GetMapping("/chapitre/reference/{reference}")
    public List<Article> findByChapitreReference(@PathVariable String reference) {
        return articleService.findByChapitreReference(reference);
    }

    @GetMapping("/")
    public List<Article> findAll() {
        return articleService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Article article) {
        return articleService.save(article);
    }

    @GetMapping("/libelleChapitre/{libelleChapitre}")
    public List<Article> findByLibelleChapitre(@PathVariable String libelleChapitre) {
        return articleService.findByLibelleChapitre(libelleChapitre);
    }

    @Autowired
    ArticleService articleService;
}
