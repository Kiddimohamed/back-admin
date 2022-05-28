package com.example.backadmin.dao;

import com.example.backadmin.bean.TableauBesoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TableauBesoinDao extends JpaRepository<TableauBesoin,Long> {
TableauBesoin findByReference(String reference);
}
