package com.miko.demo.mongo.model;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 12/26/13
 */


public class EntityB {

    private String name;

    private Long value;


    public EntityB() {
    }

    public EntityB(String name, Long value) {
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

    @Override
    public String toString() {
        return "EntityB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
