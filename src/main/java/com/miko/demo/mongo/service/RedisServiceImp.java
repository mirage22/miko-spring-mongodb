package com.miko.demo.mongo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/2/14
 */

@Service("redisService")
@SuppressWarnings("unchecked")
public class RedisServiceImp implements RedisService {

    private Logger logger = LoggerFactory.getLogger(RedisServiceImp.class);

    @Override
    public String getMessage(String name) {
        return null;
    }
}
