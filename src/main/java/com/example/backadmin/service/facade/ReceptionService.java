package com.example.backadmin.service.facade;


import com.example.backadmin.bean.Reception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ReceptionService {


    Reception findByReferenceReception(String reference);

    List<Reception> findAll();
}
