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
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
 * Date: 1/2/14
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-core-config-test.xml")
public class RedisInitTest {

    @Autowired
    JedisConnectionFactory connectionFactory;


    private Logger logger = LoggerFactory.getLogger(RedisInitTest.class);

    @Test
    public void initRedisTest(){
        String hostname = connectionFactory.getHostName();

        logger.debug("Init Redis Test =  " + hostname);

        Assert.hasText(hostname);
    }

    @Test
    public void testRedisTemplate(){
        RedisTemplate<String, Long> redis = new RedisTemplate<>();
        redis.setConnectionFactory(connectionFactory);
        redis.setKeySerializer(RedisStringSerializer.INSTANCE);
        redis.setValueSerializer(RedisLongSerializer.INSTANCE);
        redis.afterPropertiesSet();



        ValueOperations<String, Long> ops = redis.opsForValue();

        String key1 = "miko-spring-mongo:counter-test";
        String key2 = "miko-spring-mongo:counter-test-2";
        logger.debug("redistTemplate ops = " + ops);

        ops.setIfAbsent(key1, 1L);
        ops.setIfAbsent(key2, 22L);
        Long l = ops.increment(key1, 1);

        logger.debug("redistTemplate L = " + l);

        assertThat(l, is(greaterThan(0L)));
    }

    @Test
    public void testAtomicCounters() {
        RedisAtomicLong counter = new RedisAtomicLong("miko-spring-mongo:counter-test", connectionFactory, 0);
        Long l = counter.incrementAndGet();

        assertThat(l, is(greaterThan(0L)));
    }

    @Test
    public void testKeyValue(){
        RedisTemplate<String, Long> redis = new RedisTemplate<>();
        redis.setConnectionFactory(connectionFactory);
        redis.setKeySerializer(RedisStringSerializer.INSTANCE);
        redis.setValueSerializer(RedisLongSerializer.INSTANCE);
        redis.afterPropertiesSet();

        ValueOperations<String, Long> ops = redis.opsForValue();
        String key = "spring-postgresql:counter-test";

        Long value = ops.get(key);
        logger.debug("VALUE = " + value);

        assertThat(value, notNullValue());
    }
}
