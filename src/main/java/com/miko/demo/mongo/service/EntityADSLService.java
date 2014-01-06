package com.miko.demo.mongo.service;

import com.miko.demo.mongo.model.EntityA;
import com.mysema.query.types.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/4/14
 */
public interface EntityADSLService {

    EntityA findOne(Predicate predicate);

    void delete(EntityA entityA);
}
