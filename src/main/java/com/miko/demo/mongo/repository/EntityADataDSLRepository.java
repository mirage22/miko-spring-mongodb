package com.miko.demo.mongo.repository;

import com.miko.demo.mongo.model.EntityA;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/3/14
 */
public interface EntityADataDSLRepository extends CrudRepository<EntityA, Long>, QueryDslPredicateExecutor<EntityA> {


}
