package com.company.isobserve.security;

import com.company.isobserve.entity.Node;
import com.company.isobserve.entity.ZabbixServer;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "Mobile user role", code = "mobile-user-role")
public interface MobileUserRole {

    // --- Node permissions ---
    @EntityPolicy(entityClass = Node.class, actions = {EntityPolicyAction.READ})
    @EntityAttributePolicy(entityClass = Node.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    void nodePolicies();

    // --- ZabbixServer permissions ---
    @EntityPolicy(entityClass = ZabbixServer.class, actions = {EntityPolicyAction.READ})
    @EntityAttributePolicy(entityClass = ZabbixServer.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    void zabbixServerPolicies();
}
