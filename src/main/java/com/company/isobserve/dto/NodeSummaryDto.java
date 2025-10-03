package com.company.isobserve.dto;

public class NodeSummaryDto {
    private final String id;
    private final String name;
    private final String status;   // <-- меняем на String
    private final Integer problemLevel;

    public NodeSummaryDto(String id,
                          String name,
                          String status,
                          Integer problemLevel) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.problemLevel = problemLevel;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Integer getProblemLevel() {
        return problemLevel;
    }
}
