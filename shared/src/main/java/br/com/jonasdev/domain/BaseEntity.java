package br.com.jonasdev.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    protected BaseEntity() {}

    protected BaseEntity(Long id) {
        this.id = id;
    }

    protected BaseEntity(Long id, Integer version, String tenantId) {
        this.id = id;
        this.version = version;
        this.tenantId = tenantId;
    }

    private Long id;

    private Integer version;

    private String tenantId;

}
