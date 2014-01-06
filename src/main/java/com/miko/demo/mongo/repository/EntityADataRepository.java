package com.miko.demo.mongo.repository;

import com.miko.demo.mongo.model.EntityA;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 12/26/13
 */

public interface EntityADataRepository extends Repository<EntityA, Long> {

    EntityA findOne(Long id);

    EntityA findByName(String name);

    EntityA save(EntityA entityA);

    List<EntityA> findAll();

    void delete(EntityA entityA);
}
