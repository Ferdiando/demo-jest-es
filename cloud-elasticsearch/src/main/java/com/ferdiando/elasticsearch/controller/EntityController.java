package com.ferdiando.elasticsearch.controller;

import com.ferdiando.elasticsearch.entity.EsEntity;
import com.ferdiando.elasticsearch.service.CityESService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/entityController")
public class EntityController {


    @Autowired
    CityESService cityESService;

    @RequestMapping(value="/save", method=RequestMethod.GET)
    public String save(long id, String name) {
        if(id>0 && StringUtils.isNotEmpty(name)) {
            EsEntity newEntity = new EsEntity(id,name);
            List<EsEntity> addList = new ArrayList<EsEntity>();
            addList.add(newEntity);
            cityESService.saveEntity(addList);
            return "OK";
        }else {
            return "Bad input value";
        }
    }

    @RequestMapping(value="/search", method=RequestMethod.GET)
    public List<EsEntity> search(String name) {
        List<EsEntity> entityList = null;
        if(StringUtils.isNotEmpty(name)) {
            System.out.println("controller - search ....");
            entityList = cityESService.searchEntity(name);
        }
        return entityList;
    }

}
