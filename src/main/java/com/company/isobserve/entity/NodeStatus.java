package com.company.isobserve.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum NodeStatus implements EnumClass<String> {

    ;

    private final String id;

    NodeStatus(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static NodeStatus fromId(String id) {
        for (NodeStatus at : NodeStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}