package com.example.backadmin.dao;

import com.example.backadmin.bean.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciceDao extends JpaRepository<Exercice, Long> {

    Exercice findByReference(String reference);

}
