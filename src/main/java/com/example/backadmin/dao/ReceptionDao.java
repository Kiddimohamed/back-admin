
package com.example.backadmin.dao;

import com.example.backadmin.bean.Reception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptionDao extends JpaRepository<Reception,Long> {
    Reception findByReferenceReception(String reference);
    List<Reception> findAll();
}
