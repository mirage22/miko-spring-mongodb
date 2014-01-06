package com.miko.demo.mongo.service;

import com.miko.demo.mongo.model.EntityA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/1/14
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-core-config-one-test.xml")
public class EntityADeleteTest {

    @Autowired
    EntityAService entityAService;

    private Logger logger = LoggerFactory.getLogger(EntityADeleteTest.class);

    @Test
    public void deleteEntityATest(){

        EntityA entityA1 = entityAService.findByName("mirage");
        logger.debug("EntityA to Delete = " + entityA1);
        entityAService.delete(entityA1);

    }
}
