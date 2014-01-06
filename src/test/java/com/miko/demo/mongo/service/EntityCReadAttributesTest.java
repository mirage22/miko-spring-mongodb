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
