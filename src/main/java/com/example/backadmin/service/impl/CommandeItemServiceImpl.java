package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Commande;
import com.example.backadmin.bean.CommandeItem;
import com.example.backadmin.bean.Produit;
import com.example.backadmin.dao.CommandeItemDao;
import com.example.backadmin.service.facade.CommandeItemService;
import com.example.backadmin.service.facade.CommandeService;
import com.example.backadmin.service.facade.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeItemServiceImpl implements CommandeItemService {
    @Override
    public List<CommandeItem> findByCommandeCode(String code) {
        return commandeItemDao.findByCommandeCode(code);
    }

    @Override
    public List<CommandeItem> findAll() {
        return commandeItemDao.findAll();
    }

    @Override
    public int save(CommandeItem commandeItem) {
        CommandeItem commandeItem1 = findByCode(commandeItem.getCode());

        Produit produit = produitService.findByCode(commandeItem.getProduit().getCode());
        commandeItem.setProduit(produit);

        if (commandeItem1 != null) {
            return -1;
        } else if (produit == null) {
            return -2;
        } else {
            commandeItemDao.save(commandeItem);
            return 1;
        }
    }

   @Override
   public CommandeItem findByCode(String code) {
        return commandeItemDao.findByCode(code);
    }

    @Autowired
    private CommandeItemDao commandeItemDao;

    @Autowired
    private CommandeService commandeService;
    @Autowired
    private ProduitService produitService;

}
