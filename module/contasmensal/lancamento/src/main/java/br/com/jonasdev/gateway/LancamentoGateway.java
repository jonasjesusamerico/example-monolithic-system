package br.com.jonasdev.gateway;

import br.com.jonasdev.domain.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface LancamentoGateway {

    Lancamento save(final Lancamento lancamento);

    Lancamento find(final Long id);

    Page<Lancamento> findAll(Pageable page);
}
