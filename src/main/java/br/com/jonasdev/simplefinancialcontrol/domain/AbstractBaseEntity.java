package br.com.jonasdev.simplefinancialcontrol.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TenantId;

import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractBaseEntity implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Version
    @Column(name = "version", nullable = false, columnDefinition = "int default 0")
    protected Integer version;
    @Column(name = "tenant_id")
    @TenantId
    private String tenantId;

}
