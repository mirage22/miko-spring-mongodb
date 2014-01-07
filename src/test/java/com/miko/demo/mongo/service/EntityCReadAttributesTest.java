package com.miko.demo.mongo.service;

import com.miko.demo.mongo.model.EntityC;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.Map;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-core-config-test.xml")
public class EntityCReadAttributesTest {

    @Autowired
    EntityCService entityCService;

    private Logger logger = LoggerFactory.getLogger(EntityCReadAttributesTest.class);

    @Test
    public void findEntityCAndReadAttributes(){
        EntityC entityC = entityCService.findByName("mirage");


        Map<String, String> attributes = entityC.getAttributes();

        logger.debug("EntityC attributes = " + attributes);

        Assert.notNull(attributes);
    }

    @Test
    public void findEntityCAndReadSpecificAttribute(){
        EntityC entityC = entityCService.findByName("mirage");
        String attribute = entityC.getAttribute("mirage1");

        logger.debug("FindEntityC = " + entityC.getName() + " attribute= " + attribute);

        Assert.hasText(attribute);
    }

}
