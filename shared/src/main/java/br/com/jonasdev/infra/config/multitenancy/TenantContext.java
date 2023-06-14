package br.com.jonasdev.infra.config.multitenancy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class TenantContext {

    private static final InheritableThreadLocal<String> currentTenant = new InheritableThreadLocal<>();

    private TenantContext() {
    }

    public static String getTenantId() {
        return currentTenant.get();
    }

    public static void setTenantId(String tenantId) {
        log.debug("Adicionando tenant " + tenantId);
        currentTenant.set(tenantId);
    }

    public static void clear() {
        currentTenant.remove();
    }
}