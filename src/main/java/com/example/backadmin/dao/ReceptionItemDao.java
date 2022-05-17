package com.example.backadmin.dao;

import com.example.backadmin.bean.ReceptionItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionItemDao extends JpaRepository<ReceptionItem,Long> {
}
