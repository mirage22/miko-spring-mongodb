package com.miko.demo.mongo.enums;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/2/14
 */
public enum RedisStringSerializer implements RedisSerializer<String>{
    INSTANCE;

    @Override
    public byte[] serialize(String s) throws SerializationException {
        return (null != s ? s.getBytes() : new byte[0]);
    }

    @Override
    public String deserialize(byte[] bytes) throws SerializationException {
        if ( bytes.length > 0 ) {
            return new String( bytes );
        } else {
            return null;
        }
    }
}
