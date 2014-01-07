package com.miko.demo.mongo.service;

import com.miko.demo.mongo.model.EntityC;
import com.miko.demo.mongo.repository.EntityCDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
