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

/*
 * The MIT License
 *
 * Copyright 2014 Miroslav Kopecky.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

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
