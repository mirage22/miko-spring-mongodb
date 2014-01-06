package com.miko.demo.mongo.repository;

import com.miko.demo.mongo.model.EntityA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/3/14
 */

@Repository
@Profile("mongodb")
public class MongoDbEntityARepository implements EntityADataRepository{

    private final MongoOperations operations;


    @Autowired
    public MongoDbEntityARepository(MongoOperations operations) {
        Assert.notNull(operations);
        this.operations = operations;
    }

    @Override
    public EntityA findOne(Long id) {

        Query query = query(where("id").is(id));
        return operations.findOne(query, EntityA.class);
    }

    @Override
    public EntityA findByName(String name) {
        Query query = query(where("name").is(name));
        return operations.findOne(query, EntityA.class);
    }

    @Override
    public List<EntityA> findAll() {
        Query query = query(where("name").exists(true));
        return operations.find(query, EntityA.class);
    }

    @Override
    public EntityA save(EntityA entityA) {
        operations.save(entityA);
        return entityA;
    }

    @Override
    public void delete(EntityA entityA) {
        operations.remove(entityA);
    }
}
