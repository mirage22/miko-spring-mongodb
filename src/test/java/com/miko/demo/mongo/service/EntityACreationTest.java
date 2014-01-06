package com.miko.demo.mongo.service;

import com.miko.demo.mongo.model.EntityA;
import com.miko.demo.mongo.model.EntityB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 12/31/13
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-core-config-one-test.xml")
public class EntityACreationTest {

    @Autowired
    EntityAService entityAService;

    private Logger logger = LoggerFactory.getLogger(EntityACreationTest.class);

    @Test
    public void testEntitiesCreation(){

        EntityA entityA1 = new EntityA("mirage",22L);
        EntityA entityA2 = new EntityA("mikoExample", 5L);
        EntityA entityA3 = new EntityA("mikoTest", 13L);

        EntityB entityB1 = new EntityB("miko1", 1L);
        EntityB entityB2 = new EntityB("miko2", 2L);
        EntityB entityB3 = new EntityB("miko3", 3L);
        EntityB entityB4 = new EntityB("miko4", 4L);
        EntityB entityB5 = new EntityB("miko5", 5L);

        entityA1.addEntityB(entityB1);
        entityA1.addEntityB(entityB2);
        entityA2.addEntityB(entityB3);
        entityA2.addEntityB(entityB4);
        entityA3.addEntityB(entityB5);

        entityA1 = entityAService.save(entityA1);
        entityA2 = entityAService.save(entityA2);
        entityA3 = entityAService.save(entityA3);


        Assert.notNull(entityA1.getId());
        Assert.notNull(entityA2.getId());
        Assert.notNull(entityA3.getId());

    }



}
