package com.miko.demo.mongo.service;

import com.miko.demo.mongo.dto.EntityADTO;
import com.miko.demo.mongo.model.EntityA;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 12/26/13
 */
public interface EntityAService{

    EntityA findByName(String name);

    List<EntityA> findAll();

    List<EntityADTO> findAllDTO();

    EntityA save(EntityA entityA);

    void delete(EntityA entityA);
}
