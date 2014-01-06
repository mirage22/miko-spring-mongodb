package com.miko.demo.mongo.repository;

import com.miko.demo.mongo.model.EntityC;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/1/14
 */
public interface EntityCDataRepository extends CrudRepository<EntityC, Long>, QueryDslPredicateExecutor<EntityC> {
    EntityC findByName(String name);
}
