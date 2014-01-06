package com.miko.demo.mongo.config;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/5/14
 */
public class ApplicationConfigTest {

    private ConfigurableApplicationContext context;

    @After
    public void tearDown() throws Exception{
        if(context != null) context.close();
    }

    @Test
    public void bootstrapAppFromXml() {

        context = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
        assertThat(context, is(notNullValue()));
    }
}
