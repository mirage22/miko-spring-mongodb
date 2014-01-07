package com.miko.demo.mongo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
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
 * Date: 1/2/14
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-core-config-test.xml")
public class RedisPublishSubscribeTest {

    private static final String DUMP_CHANNEL = "miko-spring-mongo:pubsub-test:dump";

    private Logger logger = LoggerFactory.getLogger(RedisPublishSubscribeTest.class);

    @Autowired
    JedisConnectionFactory connectionFactory;


    @Test
    public void testRedisSubNoConversation(){
        RedisConnection redis = connectionFactory.getConnection();
        try {
            redis.publish(DUMP_CHANNEL.getBytes(), "Hello World!".getBytes() );
        } finally {
            redis.close();
        }

    }

    @Test
    public void testPubSubWithConversion() {
        RedisConnection redis = connectionFactory.getConnection();

        RedisMessageListenerContainer listeners = new RedisMessageListenerContainer();
        listeners.setConnectionFactory(connectionFactory);

        MessageListenerAdapter listener = new MessageListenerAdapter( new BeanMessageListener() );
        listener.setSerializer( new BeanMessageSerializer() );
        listener.afterPropertiesSet();

        listeners.addMessageListener( listener, new ChannelTopic(DUMP_CHANNEL) );
        listeners.afterPropertiesSet();
        listeners.start();

        try {
            redis.publish( DUMP_CHANNEL.getBytes(), "Hello World!".getBytes() );
        } finally {
            redis.close();
            listeners.stop();
        }
    }

    private class BeanMessage {
        String message;

        private BeanMessage( String message ) {
            this.message = message;
        }
    }

    private class BeanMessageListener {
        public void handleMessage( BeanMessage msg ) {
            logger.debug( "msg: " + msg.message );
        }
    }

    private class BeanMessageSerializer implements RedisSerializer<BeanMessage> {
        @Override public byte[] serialize( BeanMessage beanMessage ) throws SerializationException {
            return (null != beanMessage.message ? beanMessage.message.getBytes() : new byte[0]);
        }

        @Override public BeanMessage deserialize( byte[] bytes ) throws SerializationException {
            return new BeanMessage( new String( bytes ) );
        }
    }
}
