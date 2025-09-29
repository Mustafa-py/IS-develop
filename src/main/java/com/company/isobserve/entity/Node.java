package com.company.isobserve.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

/**
 * Node entity represents a monitored host or device coming from Zabbix.
 * It contains both Zabbix-specific identifiers and application-specific metadata.
 */
@JmixEntity
@Table(name = "NODE", indexes = {
        @Index(name = "IDX_NODE_ZABBIX_SERVER_ID", columnList = "ZABBIX_SERVER_ID"),
        @Index(name = "IDX_NODE_ZABBIX_ID", columnList = "ZABBIX_ID")
})
@Entity
public class Node {

    @Id
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    private UUID id;

    /**
     * Identifier of the node in Zabbix.
     */
    @Column(name = "ZABBIX_ID", length = 64, nullable = false)
    @NotBlank
    private String zabbixId;

    /**
     * Human-readable name of the node (from Zabbix).
     */
    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotBlank
    @Size(max = 255)
    private String name;

    /**
     * Main IP address of the node.
     */
    @Column(name = "IP_ADDRESS", length = 64)
    private String ipAddress;

    /**
     * Latitude of the node location.
     */
    @Column(name = "LOCATION_LAT")
    private Double locationLat;

    /**
     * Longitude of the node location.
     */
    @Column(name = "LOCATION_LON")
    private Double locationLon;

    /**
     * Current status of the node.
     * Could be extended in the future with an enum, e.g. OK / PROBLEM / UNKNOWN.
     */
    @Column(name = "STATUS", length = 32)
    private String status;

    /**
     * Problem severity level (1–5).
     */
    @Column(name = "PROBLEM_LEVEL")
    @Min(1)
    @Max(5)
    private Integer problemLevel;

    /**
     * Reference to the Zabbix server this node belongs to.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ZABBIX_SERVER_ID", nullable = false)
    private ZabbixServer zabbixServer;

    // =========================
    // Getters & Setters
    // =========================

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getZabbixId() {
        return zabbixId;
    }

    public void setZabbixId(String zabbixId) {
        this.zabbixId = zabbixId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Double getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(Double locationLat) {
        this.locationLat = locationLat;
    }

    public Double getLocationLon() {
        return locationLon;
    }

    public void setLocationLon(Double locationLon) {
        this.locationLon = locationLon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProblemLevel() {
        return problemLevel;
    }

    public void setProblemLevel(Integer problemLevel) {
        if (problemLevel != null && (problemLevel < 1 || problemLevel > 5)) {
            throw new IllegalArgumentException("Problem level must be between 1 and 5");
        }
        this.problemLevel = problemLevel;
    }

    public ZabbixServer getZabbixServer() {
        return zabbixServer;
    }

    public void setZabbixServer(ZabbixServer zabbixServer) {
        this.zabbixServer = zabbixServer;
    }

    // =========================
    // Utility
    // =========================

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", zabbixId='" + zabbixId + '\'' +
                ", name='" + name + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", locationLat=" + locationLat +
                ", locationLon=" + locationLon +
                ", status='" + status + '\'' +
                ", problemLevel=" + problemLevel +
                '}';
    }
}