package com.example.backadmin.service.impl;

//import com.example.agenceservicenumerique.bean.ServiceDemandeur;
//import com.example.agenceservicenumerique.bean.User;
//import com.example.agenceservicenumerique.dao.UserDao;
//import com.example.agenceservicenumerique.service.facade.ServiceDemandeurService;
//import com.example.agenceservicenumerique.service.facade.UserService;
import com.example.backadmin.bean.User;
import com.example.backadmin.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
//    @Override
//    public User findByRef(String ref) {
//        return userDao.findBy(ref);
//    }

    @Override
    public User findByUserName(String name) {
        return null;
    }

    @Override
    public User findByRef(String ref) {
        return null;
    }

    @Override
    public int save(User user) {
        return 1;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
//
//    @Override
//    public int save(User user) {
//        ServiceDemandeur serviceDemandeur=serviceDemandeurService.findByReference(user.getServiceDemandeur().getReference());
//        user.setServiceDemandeur(serviceDemandeur);
//        User user1=findByRef(user.getRef());
//        if (user1!=null){
//            return -1;
//        }else if(serviceDemandeur==null){
//            return -2;
//        }else{
//            userDao.save(user);
//            return 1;
//        }
//    }

//    @Autowired
//    ServiceDemandeurService serviceDemandeurService;
//    @Autowired
//    UserDao userDao;
}
