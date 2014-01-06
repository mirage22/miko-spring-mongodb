package com.miko.demo.mongo.service;

import com.miko.demo.mongo.model.EntityC;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/1/14
 */
public interface EntityCService {

    EntityC findByName(String name);

    Iterable<EntityC> findAll();

    EntityC save(EntityC entityC);

    void delete(EntityC entityC);
}
