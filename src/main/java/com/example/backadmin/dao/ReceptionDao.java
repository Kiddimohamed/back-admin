package com.example.backadmin.dao;

import com.example.backadmin.bean.Reception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionDao extends JpaRepository<Reception,Long> {
    //TODO creat Dao and Services To Reception and reception item
}
