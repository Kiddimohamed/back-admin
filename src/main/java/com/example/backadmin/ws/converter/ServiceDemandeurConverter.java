package com.example.backadmin.ws.converter;

import com.example.backadmin.bean.ServiceDemandeur;
import com.example.backadmin.ws.provide.ServiceDemandeurVo;
import org.springframework.stereotype.Component;

import java.rmi.ServerError;
import java.util.List;

@Component
public class ServiceDemandeurConverter extends AbstractConverter<ServiceDemandeur,ServiceDemandeurVo> {



    public ServiceDemandeurVo toVo(ServiceDemandeur bean){
        ServiceDemandeurVo vo=new ServiceDemandeurVo();
        if(bean.getReference()!=null){
            vo.setReference(bean.getReference());
        }
        if(bean.getNom()!=null){
            vo.setNom(bean.getNom());
        }
        if(bean.getId()!=null){
            vo.setId(bean.getId());
        }
        return vo;
    }
    //convert to vo
    public ServiceDemandeur toItem(ServiceDemandeurVo vo){
        ServiceDemandeur bean=new ServiceDemandeur();
        if(vo.getReference()!=null){
            bean.setReference(vo.getReference());
        }
        if(vo.getNom()!=null){
            bean.setNom(vo.getNom());
        }
        if(vo.getId()!=null){
            bean.setId(vo.getId());
        }
        return bean;
    }


    //greate

}
