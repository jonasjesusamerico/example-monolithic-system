package br.com.jonasdev.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Lancamento extends AggregateRoot {

    Long getId();

    LocalDate getData();

    String getDescricao();

    String getPessoaDescricao();

    String getModalidade();

    String getFormaPagamento();

    BigDecimal getValor();

    String getStatus();

}
