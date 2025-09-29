package com.company.isobserve.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

/**
 * ZabbixServer entity stores connection information to a Zabbix API endpoint.
 * Supports multiple Zabbix servers for distributed monitoring environments.
 */
@JmixEntity
@Table(name = "ZABBIX_SERVER", indexes = {
        @Index(name = "IDX_ZABBIX_SERVER_URL", columnList = "URL")
})
@Entity
public class ZabbixServer {

    @Id
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    private UUID id;

    /**
     * Friendly name of this Zabbix server.
     */
    @InstanceName
    @Column(name = "NAME", nullable = false, unique = true, length = 128)
    @NotBlank
    @Size(max = 128)
    private String name;

    /**
     * API endpoint URL, e.g. http://zabbix.local/api_jsonrpc.php
     */
    @Column(name = "URL", nullable = false, length = 512)
    @NotBlank
    private String url;

    /**
     * Username for API authentication.
     */
    @Column(name = "USERNAME", nullable = false, length = 128)
    @NotBlank
    private String username;

    /**
     * Password for API authentication.
     * ⚠️ In production, should be stored encrypted via Jmix Secret Storage or similar.
     */
    @Column(name = "PASSWORD", nullable = false, length = 256)
    @NotBlank
    private String password;

    /**
     * Whether this Zabbix server is enabled for synchronization.
     */
    @Column(name = "ENABLED", nullable = false)
    private Boolean enabled = Boolean.TRUE;

    // =========================
    // Getters & Setters
    // =========================

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Set password (plain). In future, consider encrypting before saving.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    // =========================
    // Utility
    // =========================

    @Override
    public String toString() {
        return "ZabbixServer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
