package br.com.jonasdev.gateway;

import br.com.jonasdev.domain.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LancamentoGateway {

    Lancamento save(final Lancamento lancamento);

    Lancamento update(final Lancamento lancamento);

    Lancamento find(final Long id);

    Page<Lancamento> findAllPageable(Pageable page);

    void delete(Long id);

    List<Lancamento> findAll();
}
