package com.miko.demo.mongo.dto;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/5/14
 */
public class EntityADTO {
    public String name;
    public Long value;

    public EntityADTO() {
    }

    public EntityADTO(String name, Long value) {
        this.name = name;
        this.value = value;
    }
}
