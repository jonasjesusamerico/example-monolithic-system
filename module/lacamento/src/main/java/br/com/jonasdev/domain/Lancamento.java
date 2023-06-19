package br.com.jonasdev.domain;

import br.com.jonasdev.repository.LancamentoModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lancamento extends BaseEntity implements AggregateRoot {

    private LocalDate data;
    private String descricao;
    private String pessoaDescricao;
    private String modalidade;
    private String formaPagamento;
    private BigDecimal valor;
    private String status;

    public Lancamento(Long id,
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

    public static Lancamento toModel(LancamentoModel lancamentoModel) {
        return new Lancamento(
                lancamentoModel.getId(),
                lancamentoModel.getData(),
                lancamentoModel.getDescricao(),
                lancamentoModel.getPessoaDescricao(),
                lancamentoModel.getModalidade(),
                lancamentoModel.getFormaPagamento(),
                lancamentoModel.getValor(),
                lancamentoModel.getStatus()
        );
    }

    public static Lancamento toModel() {
        return new Lancamento();
    }
}
