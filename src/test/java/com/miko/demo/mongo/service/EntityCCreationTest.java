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

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/1/14
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-core-config-test.xml")
public class EntityCCreationTest {

    @Autowired
    EntityCService entityCService;

    private Logger logger = LoggerFactory.getLogger(EntityCCreationTest.class);

    @Test
    public void createEntityCWithAttributes(){
        EntityC entityC = new EntityC("mirage", BigDecimal.valueOf(2));
        entityC.setAttribute("mirage1", "value1");
        entityC.setAttribute("mirage2", "value2");

        entityC = entityCService.save(entityC);

        Assert.notNull(entityC.getId());
    }

}
