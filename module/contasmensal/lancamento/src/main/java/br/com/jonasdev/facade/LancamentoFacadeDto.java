package br.com.jonasdev.facade;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder(toBuilder = true)
@Getter
public class LancamentoFacadeDto {

    private Long id;

    private LocalDate data;

    private String descricao;

    private String pessoaDescricao;

    private String modalidade;

    private String formaPagamento;

    private BigDecimal valor;

    private String status;

}
