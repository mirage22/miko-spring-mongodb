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