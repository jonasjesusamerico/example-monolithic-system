package br.com.jonasdev.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
class LancamentoImpl extends BaseEntity implements Lancamento {

    private LocalDate data;
    private String descricao;
    private String pessoaDescricao;
    private String modalidade;
    private String formaPagamento;
    private BigDecimal valor;
    private String status;


    @Builder
    public LancamentoImpl(Long id,
                          LocalDate data,
                          String descricao,
                          String pessoaDescricao,
                          String modalidade,
                          String formaPagamento,
                          BigDecimal valor,
                          String status) {
        super(id);
        this.data = data;
        this.descricao = descricao;
        this.pessoaDescricao = pessoaDescricao;
        this.modalidade = modalidade;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
        this.status = status;
    }
}
