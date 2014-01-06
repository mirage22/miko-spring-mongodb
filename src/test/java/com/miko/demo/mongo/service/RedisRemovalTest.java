package com.miko.demo.mongo.service;

import com.miko.demo.mongo.enums.RedisLongSerializer;
import com.miko.demo.mongo.enums.RedisStringSerializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/2/14
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-core-config-test.xml")
public class RedisRemovalTest {

    private Logger logger = LoggerFactory.getLogger(RedisRemovalTest.class);

    @Autowired
    JedisConnectionFactory connectionFactory;


    @Test
    public void removalKeyValueTest(){
        RedisTemplate<String, Long> redis = new RedisTemplate<>();
        redis.setConnectionFactory(connectionFactory);
        redis.setKeySerializer(RedisStringSerializer.INSTANCE);
        redis.setValueSerializer(RedisLongSerializer.INSTANCE);
        redis.afterPropertiesSet();


        ValueOperations<String, Long> ops = redis.opsForValue();

        String key1 = "miko-spring-mongo:counter-test";
        String key2 = "miko-spring-mongo:counter-test-2";


        Set<String> keys = redis.keys(key1);
        for(String foundKey: keys){
            logger.debug("Found Key= " + foundKey + " value= " + ops.get(foundKey));
        }

        redis.delete(key2);

    }


}
