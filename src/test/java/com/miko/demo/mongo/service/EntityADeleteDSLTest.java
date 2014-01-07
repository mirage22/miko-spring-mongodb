package com.miko.demo.mongo.service;

import com.miko.demo.mongo.model.EntityA;
import com.miko.demo.mongo.model.QEntityA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-core-config-one-test.xml")
public class EntityADeleteDSLTest {

    @Autowired
    EntityADSLService entityADSLService;


    private static final QEntityA entityA = QEntityA.entityA;

    private Logger logger = LoggerFactory.getLogger(EntityADeleteTest.class);

    @Test
    public void deleteEntityATest(){

        EntityA entityA1 = entityADSLService.findOne(entityA.name.eq("mirage"));
        logger.debug("EntityA DSL to Delete = " + entityA1);
        entityADSLService.delete(entityA1);

    }
}