package com.miko.demo.mongo.model;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/1/14
 */

@Document
public class EntityC extends com.miko.demo.mongo.model.AbstractEntity {


    private String name;

    private BigDecimal value;

    private Map<String, String> attributes = new HashMap<>();

    public EntityC() {
    }

    @PersistenceConstructor
    public EntityC(String name, BigDecimal value) {

        Assert.hasText(name, "Name can not be empty");
        Assert.isTrue(BigDecimal.ZERO.compareTo(value) < 0, "Value must be greater than zero!");

        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setAttribute(String name, String value) {

        Assert.hasText(name);

        if (value == null) {
            this.attributes.remove(value);
        } else {
            this.attributes.put(name, value);
        }
    }

    public String getAttribute(String Key){
        return attributes.get(Key);
    }

    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(attributes);
    }
}
