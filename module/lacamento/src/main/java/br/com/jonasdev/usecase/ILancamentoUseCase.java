package br.com.jonasdev.usecase;

import br.com.jonasdev.domain.Lancamento;
import br.com.jonasdev.facade.AddProductFacadeInputDto;

import java.util.List;

public interface ILancamentoUseCase {

    public Lancamento add(AddProductFacadeInputDto inputDto);

    public Lancamento findById(Long id);

    public List<Lancamento> findAll();

}
