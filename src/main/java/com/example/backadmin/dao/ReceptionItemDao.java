package com.example.backadmin.dao;

import com.example.backadmin.bean.ReceptionItem;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceptionItemDao extends JpaRepository<ReceptionItem,Long> {

    ReceptionItem findByReferenceReceptionItem(String reference);

    List<ReceptionItem> findByReceptionReferenceReception(String referenceReception);
}
