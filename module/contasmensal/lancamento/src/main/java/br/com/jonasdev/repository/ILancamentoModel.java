package br.com.jonasdev.repository;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface ILancamentoModel {

    LocalDate getData();

    String getDescricao();

    String getPessoaDescricao();

    String getModalidade();

    String getFormaPagamento();

    BigDecimal getValor();

    String getStatus();

    Long getId();

    Integer getVersion();

    String getTenantId();

}
