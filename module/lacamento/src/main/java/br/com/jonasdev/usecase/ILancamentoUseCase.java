package br.com.jonasdev.usecase;

import br.com.jonasdev.domain.Lancamento;

import java.util.List;

public interface ILancamentoUseCase {

    public Lancamento add(Lancamento inputDto);

    public Lancamento findById(Long id);

    public List<Lancamento> findAll();

}
