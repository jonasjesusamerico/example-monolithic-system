package br.com.jonasdev.facade;

import java.util.List;

public interface ILancamentoFacade {

    LancamentoFacadeDto save(LancamentoFacadeDto input);

    LancamentoFacadeDto findById(Long id);

    List<LancamentoFacadeDto> findAll();
}
