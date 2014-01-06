package com.miko.demo.mongo.service;

import com.miko.demo.mongo.dto.EntityADTO;
import com.miko.demo.mongo.model.EntityA;
import com.miko.demo.mongo.repository.EntityADataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 12/26/13
 */

@Service("entityAService")
@SuppressWarnings("unchecked")
public class EntityAServiceImpl implements EntityAService {

    @Autowired
    private EntityADataRepository entityADataRepository;

    private Logger logger = LoggerFactory.getLogger(EntityAServiceImpl.class);


    @Override
    public EntityA findByName(String name) {
        return entityADataRepository.findByName(name);
    }

    @Override
    public List<EntityA> findAll() {
        return entityADataRepository.findAll();
    }

    @Override
    public List<EntityADTO> findAllDTO() {
        List<EntityADTO> result = new ArrayList<>();

        for(EntityA entityA: findAll()){
            result.add(new EntityADTO(entityA.getName(), entityA.getValue()));
        }

        return result;
    }

    @Override
    public EntityA save(EntityA entityA) {
        return entityADataRepository.save(entityA);
    }

    @Override
    public void delete(EntityA entityA) {
        entityADataRepository.delete(entityA);
    }
}
