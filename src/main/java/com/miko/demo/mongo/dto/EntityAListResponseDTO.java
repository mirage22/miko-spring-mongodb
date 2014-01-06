package com.miko.demo.mongo.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/5/14
 */
public class EntityAListResponseDTO {
    public String name;
    public boolean status;

    public List<EntityADTO> list = new ArrayList<>();

    public EntityAListResponseDTO() {
    }

    public EntityAListResponseDTO(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return "EntityAListResponseDTO{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
