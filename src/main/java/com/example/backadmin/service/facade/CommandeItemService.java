package com.example.backadmin.service.facade;

import com.example.backadmin.bean.CommandeItem;

import java.util.List;

public interface CommandeItemService {
    List<CommandeItem> findByCommandeCode(String code);

    List<CommandeItem> findAll();

    int save(CommandeItem commandeItem);

    CommandeItem findByCode(String code);
}
