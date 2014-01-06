package com.miko.demo.mongo.service;

import com.miko.demo.mongo.model.EntityC;
import com.miko.demo.mongo.repository.EntityCDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/1/14
 */

@Service("entityCService")
@SuppressWarnings("unchecked")
public class EntityCServiceImpl implements EntityCService {

    @Autowired
    EntityCDataRepository entityCDataRepository;


    private Logger logger = LoggerFactory.getLogger(EntityCServiceImpl.class);

    @Override
    public EntityC findByName(String name) {
        return entityCDataRepository.findByName(name);
    }

    @Override
    public Iterable<EntityC> findAll() {
        return entityCDataRepository.findAll();
    }

    @Override
    public EntityC save(EntityC entityC) {
        return entityCDataRepository.save(entityC);
    }

    @Override
    public void delete(EntityC entityC) {
        entityCDataRepository.delete(entityC);
    }
}
