package com.miko.demo.mongo.enums;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/2/14
 */
public enum RedisLongSerializer  implements RedisSerializer<Long> {
    INSTANCE;

    @Override
    public byte[] serialize(Long aLong) throws SerializationException {
        if ( null != aLong ) {
            return aLong.toString().getBytes();
        } else {
            return new byte[0];
        }
    }

    @Override
    public Long deserialize(byte[] bytes) throws SerializationException {
        if ( bytes.length > 0 ) {
            return Long.parseLong( new String( bytes ) );
        } else {
            return null;
        }
    }
}
