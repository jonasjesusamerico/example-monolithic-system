package br.com.jonasdev.gateway;

import br.com.jonasdev.domain.Lancamento;

import java.util.List;

public interface LancamentoGateway {

    Lancamento add(final Lancamento lancamento);

    Lancamento find(final Long id);

    List<Lancamento> findAll();
}
