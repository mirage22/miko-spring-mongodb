package com.miko.demo.mongo.model;


import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 12/26/13
 */

@Document
public class EntityA extends com.miko.demo.mongo.model.AbstractEntity {

    @Field("name")
    @Indexed(unique = true)
    private String name;
    private Long value;
    private Set<EntityB> entityBSet = new HashSet<>();

    /**
     * An empty constructor is needed to create a new instance via reflection by the persistence framework.
     * Hibernate needs to instantiate objects.  Hibernate needs to create instances as result of a queries
     * (via reflection), Hibernate relies on the no-arg constructor of entities for that. Hibernate uses
     * proxies for lazy loading.
     */
    public EntityA() {
    }

    public EntityA(String name, Long value) {

        Assert.notNull(value);
        Assert.hasText(name);

        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Set<EntityB> getEntityBSet() {
        return Collections.unmodifiableSet(entityBSet);
    }

    public void setEntityBSet(Set<EntityB> entityBSet) {
        this.entityBSet = entityBSet;
    }

    public void addEntityB(EntityB entityB){
        Assert.notNull(entityB);
        this.entityBSet.add(entityB);
    }

    @Override
    public String toString() {
        return "EntityA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
