package br.com.jonasdev.facade;

import br.com.jonasdev.domain.Lancamento;

import java.util.List;

public interface ILancamentoFacade {

    Lancamento add(AddProductFacadeInputDto input);

    Lancamento findById(Long id);

    List<Lancamento> findAll();
}
