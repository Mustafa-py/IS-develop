package com.company.isobserve.entity;

import io.jmix.core.metamodel.datatype.EnumClass;
import org.springframework.lang.Nullable;

public enum NodeStatus implements EnumClass<String> {

    OK("OK"),
    PROBLEM("PROBLEM"),
    UNKNOWN("UNKNOWN");

    private final String id;

    NodeStatus(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Nullable
    public static NodeStatus fromId(String id) {
        for (NodeStatus status : NodeStatus.values()) {
            if (status.getId().equals(id)) {
                return status;
            }
        }
        return null;
    }
}
