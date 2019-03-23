package com.ferdiando.elasticsearch.service;


import com.ferdiando.elasticsearch.entity.EsEntity;

import java.util.List;

public interface CityESService {

    void saveEntity(EsEntity entity);

    void saveEntity(List<EsEntity> entityList);

    List<EsEntity> searchEntity(String searchContent);
}