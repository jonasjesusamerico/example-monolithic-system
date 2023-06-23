package br.com.jonasdev.repository;

import br.com.jonasdev.domain.AbstractBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "LANCAMENTO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class LancamentoModel extends AbstractBaseEntity implements ILancamentoModel {


    @Column(name = "DATA")
    private LocalDate data;

    @Column(name = "DESCRICAO", length = 255)
    private String descricao;

    @Column(name = "PESSOA_DESCRICAO", length = 255)
    private String pessoaDescricao;

    @Column(name = "MODALIDADE", length = 255)
    private String modalidade;

    @Column(name = "FORMA_PAGAMENTO", length = 255)
    private String formaPagamento;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "STATUS", length = 255)
    private String status;


    @Builder(toBuilder = true)
    public LancamentoModel(Long id,
                           Integer version,
                           String tenantId,
                           LocalDate data,
                           String descricao,
                           String pessoaDescricao,
                           String modalidade,
                           String formaPagamento,
                           BigDecimal valor,
                           String status) {
        super(id, version, tenantId);
        this.data = data;
        this.descricao = descricao;
        this.pessoaDescricao = pessoaDescricao;
        this.modalidade = modalidade;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
        this.status = status;
    }
}
