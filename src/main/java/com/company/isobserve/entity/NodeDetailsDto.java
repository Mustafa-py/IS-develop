package com.company.isobserve.entity;

public class NodeDetailsDto {
    private final String id;
    private final String name;
    private final String status;   // <-- String вместо NodeStatus
    private final Integer problemLevel;
    private final String ipAddress;
    private final Double locationLat;
    private final Double locationLon;
    private final String zabbixServerName;

    public NodeDetailsDto(String id,
                          String name,
                          String status,
                          Integer problemLevel,
                          String ipAddress,
                          Double locationLat,
                          Double locationLon,
                          String zabbixServerName) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.problemLevel = problemLevel;
        this.ipAddress = ipAddress;
        this.locationLat = locationLat;
        this.locationLon = locationLon;
        this.zabbixServerName = zabbixServerName;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public Double getLocationLat() {
        return locationLat;
    }

    public Double getLocationLon() {
        return locationLon;
    }

    public String getZabbixServerName() {
        return zabbixServerName;
    }
}

