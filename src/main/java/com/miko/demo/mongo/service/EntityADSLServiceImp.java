package com.miko.demo.mongo.service;

import com.miko.demo.mongo.model.EntityA;
import com.miko.demo.mongo.repository.EntityADataDSLRepository;
import com.mysema.query.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/4/14
 */

@Service("entityADSLService")
@SuppressWarnings("unchecked")
public class EntityADSLServiceImp implements EntityADSLService {

    @Autowired
    EntityADataDSLRepository entityADataDSLRepository;

    private Logger logger = LoggerFactory.getLogger(EntityADSLServiceImp.class);

    @Override
    public EntityA findOne(Predicate predicate) {
        return entityADataDSLRepository.findOne(predicate);
    }

    @Override
    public void delete(EntityA entityA) {
        entityADataDSLRepository.delete(entityA);
    }
}
